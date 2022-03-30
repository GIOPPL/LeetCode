import java.util.concurrent.CyclicBarrier;

/**
 * Created by GIOPPL
 * on 2021/6/25 23:08
 * TODO:
 */
public class Test {
    public static void main(String[] args) {
        Boolean fun = fun();
        System.out.println(fun);
    }

    private static Boolean fun() {
        try{
            int a=10/0;
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }


}
