package Memento;

/**
 * Created by sunpengwei on 2016/9/18.
 */

/**
 * 存储备忘录的对象的类
 */
public class Storage {

	private Memento memento;

	public Storage(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
