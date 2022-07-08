package design_mode.factory.abstract1;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:29
 * TODO:
 */
public class HuaweiPhone implements PhoneProduct{
    @Override
    public void start() {
        System.out.println("开启华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");
    }

    @Override
    public void call() {
        System.out.println("华为打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为发短信");
    }
}
