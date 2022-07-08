package design_mode.factory.abstract1;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:28
 * TODO:
 */
public class XiaomiPhone implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void call() {
        System.out.println("小米打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米发短信");
    }
}
