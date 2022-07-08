package design_mode.factory.method;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:10
 * TODO:
 */
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
