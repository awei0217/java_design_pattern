package StructureModel.Flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * Created by sunpengwei on 2016/8/5.
 */

/**
 *
 * Flyweight负责创建和管理共享单元，当一个客户端请求时，工厂需要检查当前对象池中是否有符合条件的对象，如果有，就返回已 经存在的对象，如果没有，则创建一个新对象，
 * FlyWeight是超类。一提到共享池，我们很容易联想到Java里面的JDBC连接池，想想每个连接的特 点，我们不难总结出：适用于作共享的一些个对象，
 * 他们有一些共有的属性，就拿数据库连接池来说，url、driverClassName、 username、password及dbname，这些属性对于每个连接来说都是一样的，
 * 所以就适合用享元模式来处理，建一个工厂类，将上述类似属性作 为内部数据，其它的作为外部数据，在方法调用时，当做参数传进来，这样就节省了空间，
 * 减少了实例的数量。
 */
public class ConnectPoll {
    private  Vector<Connection> polls = null;
    private String driver = "com.mysql.jdbc.Driver";
    private String url ="jdbc:mysql://localhost:3306/demo1";
    private String userName = "root";
    private String userPassWord = "root";

    Connection  conn = null;
    private static ConnectPoll instance = null;
    private  int poolSize = 100;
    public ConnectPoll(){

        polls = new Vector<Connection>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName("driver");
                conn = DriverManager.getConnection(url,userName,userPassWord);
                polls.add(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void release(Connection conn){
        polls.add(conn);
    }

    public synchronized Connection getConnection(){
        if(polls.size()>0){
           Connection conn =  polls.get(0);
            polls.remove(conn);
            return conn;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        ConnectPoll connectPoll = new ConnectPoll();
        Connection conn = connectPoll.getConnection();

    }
}
