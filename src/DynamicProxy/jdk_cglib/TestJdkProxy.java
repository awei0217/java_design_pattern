package DynamicProxy.jdk_cglib;

import net.sf.cglib.core.DebuggingClassWriter;
/**
 * 代理接口 不能代理类
 * 为什么：
 *      原因：单继承，跟class字节码生成技术有关
 *
 * Created by sunpengwei on 2017/12/28.
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        JdkProxyHandler jdkProxyHandler = new JdkProxyHandler(userService);
        UserService jdlProxy = (UserService) jdkProxyHandler.getUserServiceProxy();

        User user = new User();
        user.setName("spw");
        jdlProxy.addUser(user);
        ProxyGeneratorUtils.writeProxyClassToHardDisk("E:/$Proxy0.class");  // 生成的字节码存放的位置 ，jdkProxy


        //---------------------------------------------------------------------------------

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:/");   // 生成的字节码存放的位置 ，cglib
        UserService cglibProxy = (UserService)new CglibProxy().getInstance(userService);

        cglibProxy.addUser(user);
    }
}
