package design_mode.factory.abstract1;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:31
 * TODO:
 */
public class HuaweiRoute implements RouterProduct{
    @Override
    public void start() {
        System.out.println("华为路由器开启");
    }

    @Override
    public void shutdown() {
        System.out.println("华为路由器关闭");
    }

    @Override
    public void openWifi() {
        System.out.println("华为路由器打开WiFi");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }
}
