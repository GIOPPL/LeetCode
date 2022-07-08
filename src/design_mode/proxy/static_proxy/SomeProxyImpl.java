package design_mode.proxy.static_proxy;

/**
 * Created by GIOPPL
 * on 2022/7/8 20:47
 * TODO:
 */
public class SomeProxyImpl implements IProxyService{
    private final IProxyService someService;
    public SomeProxyImpl(IProxyService someService){
        this.someService=someService;
    }
    @Override
    public void doSomething() {
        System.out.println("操作之前做了一些事情。。。");
        someService.doSomething();
        System.out.println("操作之后做了一些事情。。。");
    }
}
