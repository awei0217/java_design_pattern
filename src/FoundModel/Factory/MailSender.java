package FoundModel.Factory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("邮件发送信息");
    }
}
