package Reactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sunpengwei on 2017/3/5.
 */
public class ReactorStudy {
	public static void main(String[] args) {
		AcceptorStudy as = new AcceptorStudy();
		new Thread(as).start();
		as.acceptorRequest(new EventStudy(EventTypeStudy.CREATE,"创建工单"),new CreateWoHandler());
		as.acceptorRequest(new EventStudy(EventTypeStudy.CREATE,"创建工单"),new CreateWoHandler());
		as.acceptorRequest(new EventStudy(EventTypeStudy.TREATED,"处理工单"),new TreatedWoHandler());
		as.acceptorRequest(new EventStudy(EventTypeStudy.TREATED,"处理工单"),new TreatedWoHandler());
		as.acceptorRequest(new EventStudy(EventTypeStudy.TREATED,"处理工单"),new TreatedWoHandler());
		as.acceptorRequest(new EventStudy(EventTypeStudy.CLOSE,"关闭工单"),new CloseWoHandler());
		as.acceptorRequest(new EventStudy(EventTypeStudy.CLOSE,"关闭工单"),new CloseWoHandler());
	}

}

class AcceptorStudy implements Runnable{
	public ServiceHandler serviceHandler = null;
	public Select select = null;
	public EventStudy event;

	public AcceptorStudy( ){
		serviceHandler = new ServiceHandler();
		select = Select.open();
	}

	/**
	 * 接受请求
	 * @param event
	 * @param eventHandler
	 */
	public void acceptorRequest(EventStudy event,EventHandlerStudy eventHandler){
		//注册handler
		serviceHandler.registerHandler(event.getEventType(),eventHandler);
		/**
		 * 往select中注册事件
		 */
		select.addEvent(event);
	}
	/**
	 *
	 */
	@Override
	public void run() {
		/**
		 * 调用 ServiceHandler分发请求
		 */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		serviceHandler.handlerEvents();
	}
}

/**
 * 管理处理请求的Handler的,并进行分发请求.
 */
class  ServiceHandler{
	public Map<EventTypeStudy,EventHandlerStudy> eventHandlers = new HashMap<EventTypeStudy,EventHandlerStudy>();

	/**
	 * 注册处理请求的handler
	 * @param eventType 事件类型
	 * @param handler 处理请求的handler（一个handler处理一个事件）
	 */
	public void registerHandler(EventTypeStudy eventType,EventHandlerStudy handler){
		eventHandlers.put(eventType,handler);
	}
	public void removerHandler(EventStudy event){
		eventHandlers.remove(event);
	}

	/**
	 * 分发请求
	 */
	public void handlerEvents(){
		dispatch();
	}

	private void dispatch() {
		while (true){
			List<EventStudy> events = Select.select();
			for (EventStudy event :events){
				EventHandlerStudy eventHandler = eventHandlers.get(event.getEventType());
				eventHandler.handler();
			}
		}
	}
}

class Select{
	static  BlockingQueue<EventStudy> events = new LinkedBlockingQueue<EventStudy>();

	public static List<EventStudy> select(){
		List<EventStudy> eventList = new ArrayList<EventStudy>();
		events.drainTo(eventList);
		return eventList;
	}

	public void addEvent(EventStudy evnet){
		try {
			events.put(evnet);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Select open(){
		return new Select();
	}
}


class EventStudy{

	public EventStudy(EventTypeStudy eventType,String eventSource){
		this.eventType = eventType;
		this.eventSource = eventSource;
	}
	public EventTypeStudy getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeStudy eventType) {
		this.eventType = eventType;
	}

	public String getEventSource() {
		return eventSource;
	}

	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	private EventTypeStudy eventType;
	private String eventSource;
}
enum EventTypeStudy{
	CREATE,TREATED,CLOSE;
}

abstract class EventHandlerStudy{
	public abstract void handler();
}

class CreateWoHandler extends EventHandlerStudy{

	@Override
	public void handler() {
		System.out.println("创建工单");
	}
}

class TreatedWoHandler extends EventHandlerStudy{

	@Override
	public void handler() {
		System.out.println("处理工单");
	}
}
class CloseWoHandler extends EventHandlerStudy{

	@Override
	public void handler() {
		System.out.println("关闭工单");
	}
}
