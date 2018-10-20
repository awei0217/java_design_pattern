package FoundModel.AbstractFactory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class MailSenderFactory implements Provide{


    @Override
    public Sender produce() {
        return new MailSender();
    }
}
