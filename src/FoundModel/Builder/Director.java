package FoundModel.Builder;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class Director {

    AbstractBuilder builder = new AbstractBuilderImpl(); //预先持有各个产品的建造类

    //为需要不同的产品提供不同的组装方式  。如生产产品A
    public Product getAProduct(){
        builder.buildPart("宝马", "X7");
        return builder.buildProduct();
    }
    //生产产品B
    public Product getBProduct(){
        builder.buildPart("宝马", "X8"); //生产
        return builder.buildProduct();  //返回
    }
}
