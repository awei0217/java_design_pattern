package Memento;

/**
 * Created by sunpengwei on 2016/9/18.
 */

/**
 * 备忘录对象。
 * 作用:当原生对象想改变自身的状态或者数据时，将当前数据线保存在备忘录对象中，等到想再要以前的数据时由备忘录对象还原
 */
public class Memento {

	public Memento(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private  String value;
}
