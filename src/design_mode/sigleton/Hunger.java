package design_mode.sigleton;

/**
 * Created by GIOPPL
 * on 2022/7/7 21:49
 * TODO:
 */
public class Hunger {
    private static final Hunger instance=new Hunger();
    private Hunger(){}
    public static Hunger getInstance(){
        return instance;
    }
}
