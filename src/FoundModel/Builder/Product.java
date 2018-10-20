package FoundModel.Builder;

/**
 * Created by sunpengwei on 2016/8/1.
 */

//产品类
public class Product {
    private String name;
    private String type;

    public Product() {
        System.out.println("名称"+name);
        System.out.println("类型"+type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
