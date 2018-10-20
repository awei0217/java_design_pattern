package Command;

/**
 * Created by sunpengwei on 2016/9/18.
 */
public class MyCommand implements Command {
	public Receive receive;

	public MyCommand(Receive receive){
		this.receive = receive;
	}
	@Override
	public boolean exec(String command) {
		return receive.execCommand(command);
	}
}
