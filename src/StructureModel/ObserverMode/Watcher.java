package StructureModel.ObserverMode;

import java.util.Observable;

/**
 * Created by sunpengwei on 2016/8/14.
 */


//主题  被观察的对象
public class Watcher extends Observable {


    // 当主题改变时 通知订阅了的观察者
    public void updateWatcher(String news){
        this.setChanged();
        this.notifyObservers(news);
    }
}
