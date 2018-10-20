package FoundModel.Prototype;

/**
 * Created by sunpengwei on 2016/8/1.
 */
//具体的原型角色
public class ConcretePrototype1 implements Prototype {

    public Object clone(){
        //最简单的克隆，新建一个自身对象

        return new ConcretePrototype1();
    }
}
