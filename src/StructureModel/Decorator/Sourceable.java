package StructureModel.Decorator;

/**
 * Created by sunpengwei on 2016/8/3.
 */

/**
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰
 * 对象实现同一个接口，装饰对象持有被装饰对象的实例，关系图如下
 */
public interface Sourceable {

    public void method();
}
