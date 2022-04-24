import java.util.concurrent.Callable;

class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep((long) (Math.random()*10*500));
        System.out.println("正在执行==>:"+Thread.currentThread().getId());
        return "hello";
    }
}
