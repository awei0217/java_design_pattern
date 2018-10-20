package FoundModel.AbstractFactory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
//这是工厂类
public class SmsSenderFactory implements Provide {



    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
