package Memento;

/**
 * Created by sunpengwei on 2016/9/18.
 */

/**
 * 原始类
 */
public class Original {

	public Original(){

	}

	/**
	 * 创建备忘录对象
	 */
	public Memento createMemento(){
		Memento memento = new Memento(this.getValue());
		return memento;
	}

	/**
	 * 还原对象
	 * @param memento
	 */
	public void restoreMemento(Memento memento){
		this.value = memento.getValue();
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;


}
