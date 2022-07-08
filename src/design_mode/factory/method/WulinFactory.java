package design_mode.factory.method;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:11
 * TODO:
 */
public class WulinFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Wulin();
    }
}
