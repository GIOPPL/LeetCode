/**
 * Created by GIOPPL
 * on 2021/6/25 23:08
 * TODO:
 */
public class Test {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

}
