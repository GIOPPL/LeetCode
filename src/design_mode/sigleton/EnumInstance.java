package design_mode.sigleton;

import java.io.Serializable;

/**
 * Created by GIOPPL
 * on 2022/7/7 21:55
 * TODO:
 */
public enum  EnumInstance {
    INSTANCE;
    public static EnumInstance getInstance(){
        return INSTANCE;
    }
    public int getA(int a,int b){
        return a+b*2;
    }
}
