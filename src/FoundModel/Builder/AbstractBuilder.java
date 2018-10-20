package FoundModel.Builder;

/**
 * Created by sunpengwei on 2016/8/1.
 */

/*建造者模式（Builder）：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
        使用场景：
        1、当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
        2、当构造过程必须允许被构造的对象有不同的表示时。*/

public abstract class AbstractBuilder { //抽象建造类

    public abstract void buildPart(String name,String type);//构建产品

    public abstract Product buildProduct(); //返回产品
}
