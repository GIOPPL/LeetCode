package design_mode.sigleton;

/**
 * Created by GIOPPL
 * on 2022/7/7 21:58
 * TODO:
 */
public class Singleton {
    int a;
    private static volatile Singleton INSTANCE;
    private Singleton(){}
    public static Singleton getInstance(){
        if (INSTANCE==null){
            synchronized (Singleton.class){
                if(INSTANCE==null){
                    INSTANCE=new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
