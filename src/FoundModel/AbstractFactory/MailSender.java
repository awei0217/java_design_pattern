package FoundModel.AbstractFactory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("这是邮件发送信息");
    }
}
