package design_mode.factory.abstract1;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:34
 * TODO:
 */
public class XiaomiFactory implements ProductFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new XiaomiRoute();
    }
}
