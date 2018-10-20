package FoundModel.Prototype;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class Client {

    private Prototype prototype; //持有需要使用的原型接口对象

    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    //根据已有的对象创建原型接口的对象(就是复制一个原来的对象)
    public Object getPrototype (){
        Prototype concretePrototype = (ConcretePrototype1) prototype.clone();
        return  concretePrototype;
    }
}
