package StructureModel.ObserverMode;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by sunpengwei on 2016/8/14.
 */

//具体的观察者
public class MyObserver1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println((String)arg);
    }
}
