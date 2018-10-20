package StructureModel.Strategy;

/**
 * Created by sunpengwei on 2016/8/5.
 */

/**
 * 具体策略类
 */
public class ConcreteStrategy implements  Strategy {
    @Override
    public void strategyInterface() {
        //相关业务
        System.out.println("相关业务");
    }
}
