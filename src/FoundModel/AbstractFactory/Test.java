package FoundModel.AbstractFactory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class Test {

    public static void main(String[] args) {
        Provide provide = new SmsSenderFactory();
        Sender smsSender =  provide.produce();
        smsSender.send();

        Provide provide1 = new MailSenderFactory();
        Sender mailSender = provide1.produce();
        mailSender.send();
    }
}
