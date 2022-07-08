//import org.junit.test.Test;


/**
 * Created by GIOPPL
 * on 2021/5/26 21:23
 * TODO:
 */
public class Main {
    public static void main(String args[]) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        print("程序运行时间：" + (endTime - startTime) / 1000 + "k ns\n");
    }

    private static void start(){

    }

    static void print(Object s) {
        System.out.print(s);
    }

//    @test.Test
    public void test() {
        System.out.println(42 & 0xffffffff00000000L);
    }
}

