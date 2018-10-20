package DynamicProxy;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class Test {
    public static void main(String[] args) {
        HelloWord helloWord = new HelloWordImpl();
        DynamicProxyClass dynamicProxyClass = new DynamicProxyClass();
        HelloWord dynamicHelloWord = (HelloWord) dynamicProxyClass.bindRelation(helloWord);
        dynamicHelloWord.print();
    }
}
