package FoundModel.Factory;

/**
 * Created by sunpengwei on 2016/8/1.
 */
public class SmsSender implements  Sender{
    @Override
    public void sender() {
        System.out.println("短信发送信息");
    }
}
