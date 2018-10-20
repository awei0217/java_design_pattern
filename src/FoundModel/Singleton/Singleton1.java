package FoundModel.Singleton;

/**
 * Created by sunpengwei on 2016/8/1.
 */

//懒汉模式（线程不安全）
public class Singleton1 {

    public static Singleton1 singleton1 = null;
    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(singleton1==null){
            return new Singleton1();
        }
        return singleton1;
    }
}
//懒汉 线程安全
class Singleton2{
    public static Singleton2 singleton2 = null;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(singleton2 == null)
            return new Singleton2();
        return singleton2;
    }
}

//饿汉

class Singleton3{
    public static Singleton3 singleton3 = new Singleton3();

    private Singleton3(){}

    public static Singleton3 getInstance(){
        return singleton3;
    }

}
//饿汉变种
class  Singleton4{
    public static Singleton4 singleton4 = null;
    private Singleton4(){}
    //静态代码块
    static {
        singleton4 = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return singleton4;
    }
}
//静态内部类

/**
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，它跟第三种和第四种方式不同的是（很细微的差别）：第三种和第四种方式是只要Singleton类被装载了，
 * 那么instance就会被实例化（没有达到lazy loading效果），而这种方式是Singleton类被装载了，instance不一定被初始化。因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化instance。想象一下，如果实例化instance很消耗资源，我想让他延迟加载，另外一方面，我不希望在Singleton类加载时就实例化，
 * 因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。这个时候，这种方式相比第三和第四种方式就显得很合理。
 */
class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    private Singleton5 (){}
    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
//双重校验锁
class Singleton6 {
    private volatile static Singleton6 singleton6;
    private Singleton6 (){}
    public static Singleton6 getSingleton() {
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                if (singleton6 == null) {
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}