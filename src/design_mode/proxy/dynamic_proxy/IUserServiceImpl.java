package design_mode.proxy.dynamic_proxy;

/**
 * Created by GIOPPL
 * on 2022/7/8 20:48
 * TODO:
 */
public class IUserServiceImpl implements IUserService {
    @Override
    public void doSomething() {
        System.out.println("触发一些方法");
    }
}
