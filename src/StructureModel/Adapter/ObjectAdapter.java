package StructureModel.Adapter;

/**
 * Created by sunpengwei on 2016/8/2.
 */
//对象的适配器模式 ，和类的适配器模式差不多，不同的是类的适配器是extends  ClassAdapter
    //对象的适配器模式是持有一个ObjectAdapters的实例
public class ObjectAdapter {

    public void method1(){
        System.out.println("method1");
    }
}

interface Targetable1{
    public void method1();
    public void method2();
}

class Adapter1 implements Targetable1{
    private ObjectAdapter objectAdapter;
    public Adapter1(ObjectAdapter objectAdapter){
        this.objectAdapter = objectAdapter;
    }
    @Override
    public void method1() {
        objectAdapter.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
