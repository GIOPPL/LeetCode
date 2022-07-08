package design_mode.factory.abstract1;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:39
 * TODO:
 */
public class HuaweiFactory implements ProductFactory{

    @Override
    public PhoneProduct phoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouterProduct routerProduct() {
        return new HuaweiRoute();
    }
}
