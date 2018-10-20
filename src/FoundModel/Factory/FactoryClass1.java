package FoundModel.Factory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
//多个工厂方法模式
public class FactoryClass1 {

    public static Sender getSmsSender(){
        return new SmsSender();
    }

    public static Sender getMailSender(){
        return new MailSender();
    }
}
