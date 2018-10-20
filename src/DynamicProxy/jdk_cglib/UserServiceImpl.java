package DynamicProxy.jdk_cglib;

/**
 * Created by sunpengwei on 2017/12/28.
 */
public class UserServiceImpl implements  UserService {


    public void addUser(User user) {
        User user11 =new User();


        System.out.println("添加一个用户："+user.getName());
    }
}
