package design_mode.sigleton;

/**
 * Created by GIOPPL
 * on 2022/7/7 21:53
 * TODO:
 */
public class Lazy {
    private static Lazy INSTANCE;
    private Lazy(){}
    public static synchronized Lazy getInstance(){
        if(INSTANCE==null){
            INSTANCE=new Lazy();
        }
        return INSTANCE;
    }
}
