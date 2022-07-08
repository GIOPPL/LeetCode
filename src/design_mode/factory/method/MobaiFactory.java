package design_mode.factory.method;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:12
 * TODO:
 */
public class MobaiFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Mobai();
    }
}
