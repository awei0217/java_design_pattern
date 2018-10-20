package DynamicProxy.jdk_cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sunpengwei on 2017/12/28.
 */
public class JdkProxyHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object target;

    public JdkProxyHandler(Object target){
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("验证用户");
        Object result = method.invoke(target,args);
        System.out.println("缓存用户");
        return result;
    }

    public Object getUserServiceProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }



}
