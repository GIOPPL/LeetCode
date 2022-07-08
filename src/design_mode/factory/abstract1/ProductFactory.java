package design_mode.factory.abstract1;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:33
 * TODO:
 */
public interface ProductFactory {
    //生产手机
    PhoneProduct phoneProduct();
    //生产路由器
    RouterProduct routerProduct();
}
