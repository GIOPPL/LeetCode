package design_mode.factory;

import design_mode.factory.abstract1.HuaweiFactory;
import design_mode.factory.abstract1.XiaomiFactory;
import design_mode.factory.method.MobaiFactory;
import design_mode.factory.method.TeslaFactory;
import design_mode.factory.method.WulinFactory;
import design_mode.factory.simple.CarFactory;

/**
 * Created by GIOPPL
 * on 2022/7/7 22:57
 * TODO:
 */
public class FactoryMain {
    public static void main(String[] args) {
        System.out.println("------简单工厂--------");
        CarFactory.getCar("五菱").name();
        CarFactory.getCar("特斯拉").name();
        System.out.println("----------工厂方法-----------");
        new WulinFactory().getCar().name();
        new TeslaFactory().getCar().name();
        new MobaiFactory().getCar().name();
        System.out.println("----------抽象工厂-----------");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        xiaomiFactory.phoneProduct().call();
        xiaomiFactory.routerProduct().start();
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        huaweiFactory.phoneProduct().call();
        huaweiFactory.routerProduct().openWifi();
    }
}
