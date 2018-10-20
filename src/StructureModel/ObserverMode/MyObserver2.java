package StructureModel.ObserverMode;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by sunpengwei on 2016/8/14.
 */
public class MyObserver2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println((String)arg);
    }
}
