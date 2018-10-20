package FoundModel.Builder;

/**
 * Created by sunpengwei on 2016/8/1.
 */

//实现抽象建造的类，是真正的建造者
public class AbstractBuilderImpl extends AbstractBuilder {
    Product product = new Product();

    @Override
    public void buildPart(String name, String type) { //建造这个产品
            product.setName(name);
            product.setType(type);
    }

    @Override
    public Product buildProduct() {  //返回这个产品
        return product;
    }
}
