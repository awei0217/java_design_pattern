package StructureModel.Adapter;

/**
 * Created by sunpengwei on 2016/8/2.
 */

//类的适配器模式  （把ClassAdaper类适配到Targetable）
public class ClassAdapter {

    public  void method1(){
        System.out.println("method1");
    }
}

interface Targetable{
    public void method1();
    public void method2();
}
//需求是把ClassAdapter的method()适配到Targetable 接口中
class Adapter extends ClassAdapter implements Targetable{

    @Override
    public void method2() {
        System.out.println("method2");
    }
}