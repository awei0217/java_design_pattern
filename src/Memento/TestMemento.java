package Memento;

/**
 * Created by sunpengwei on 2016/9/18.
 */
public class TestMemento {

	public static void main(String[] args) {
		Original original = new Original();
		original.setValue("状态1");

		System.out.println("开始时的值："+ original.getValue());

		//进行备忘录
		Memento memento = original.createMemento();
		//存储备忘录对象
		Storage storage = new Storage(memento);

		original.setValue("状态2");
		System.out.println("修改后的值："+original.getValue());

		//还原修改前的值
		original.restoreMemento(storage.getMemento());

		System.out.println("还原后的值："+original.getValue());
	}
}
