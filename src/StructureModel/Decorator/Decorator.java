package StructureModel.Decorator;

/**
 * Created by sunpengwei on 2016/8/3.
 */

/**
 * 这是装饰类
 */

//装饰器的应用场景，需要扩展一个类的功能，而且还能动态撤销，（继承的功能是静态的，不能动态删除）
public class Decorator implements Sourceable {

    private Source source;

    public Decorator(Source source){
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator");
        source.method();
        System.out.println("after decorator");
    }
}
