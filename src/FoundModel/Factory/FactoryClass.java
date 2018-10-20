package FoundModel.Factory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class FactoryClass {

    //简单工厂模式
    public Sender getSender(String name){
        if(name.equals("sms")){
            return new SmsSender();
        }else if(name.equals("mail")){
            return new MailSender();
        }
        return null;
    }
}
