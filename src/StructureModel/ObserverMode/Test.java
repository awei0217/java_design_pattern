package StructureModel.ObserverMode;

/**
 * Created by sunpengwei on 2016/8/14.
 */
public class Test {

    public static void main(String[] args) {
        //创建观察者对象
        MyObserver1 o1 = new MyObserver1();
        MyObserver2 o2 = new MyObserver2();

        //创建主题
        Watcher watcher = new Watcher();

        //观察者订阅主题(主题把观察者添加到自己的集合里，当有变化时遍历通知各个观察者)
        watcher.addObserver(o1);
        watcher.addObserver(o2);

        watcher.updateWatcher("主题发生变化了1");
        watcher.updateWatcher("主题发生变化了2");

    }
}
