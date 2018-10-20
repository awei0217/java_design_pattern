package StructureModel.TempletModel;

/**
 * 模板方法模式需要开发抽象类和具体子类的设计师之间的协作。一个设计师负责给出一个算法的轮廓和骨架，另一些设计师则负责给出这个算法的各个逻辑步骤。
 * 代表这些具体逻辑步骤的方法称做基本方法(primitive method)；而将这些基本方法汇总起来的方法叫做模板方法(template method)，这个设计模式的名字就是
 * 从此而来。
 * 模板方法所代表的行为称为顶级行为，其逻辑称为顶级逻辑。
 */
/**
 * Created by sunpengwei on 2016/8/14.
 */

//抽象模板类
//定义了一个或多个抽象操作，以便让子类实现。这些抽象操作叫做基本操作，它们是一个顶级逻辑的组成步骤。
public abstract class AbstractTmplet {
    //相当于HttpServlet中的service的方法 ，组织调用方法
   // 这个顶级逻辑由templateMethod()方法代表
    public void templetMethod(){
        abstractM1();
        doMethod1();
        method2();
    }
    //这是
    public abstract void abstractM1(); //抽象方法

    //相当于httpServlet中的doGet 和doPost
    public void doMethod1(){}; //钩子方法

    //基本方法
    public void method2(){
        //业务逻辑
        if(true){
            System.out.println("if 进来了");
        }else {
            System.out.println("else 进来了");
        }
    }
}
