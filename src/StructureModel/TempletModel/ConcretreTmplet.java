package StructureModel.TempletModel;

/**
 * Created by sunpengwei on 2016/8/14.
 */

//具体模板类
    //定义并实现了一个模板方法。这个模板方法一般是一个具体方法，它给出了一个顶级逻辑的骨架，
    // 而逻辑的组成步骤在相应的抽象操作中，推迟到子类实现。顶级逻辑也有可能调用一些具体方法
public class ConcretreTmplet extends AbstractTmplet {




    //实现抽象方法
    @Override
    public void abstractM1() {
        System.out.println("抽象方法的实现");
    }

    //重写钩子方法
    @Override
    public void doMethod1(){
        System.out.println("钩子方法的实现");
    }
}
