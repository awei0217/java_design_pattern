package StructureModel.Decorator;

/**
 * Created by sunpengwei on 2016/8/3.
 */

/**
 * 这是一个被装饰类
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method");
    }
}
