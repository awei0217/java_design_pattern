package StructureModel.Strategy;

/**
 * Created by sunpengwei on 2016/8/5.
 */

/**
 *环境类
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    //策略方法
    public void contextInterface(){
        strategy.strategyInterface();
    }
}
