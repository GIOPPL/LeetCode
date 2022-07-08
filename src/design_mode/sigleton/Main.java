package design_mode.sigleton;

import design_mode.sigleton.EnumInstance;
import design_mode.sigleton.Hunger;
import design_mode.sigleton.Lazy;
import design_mode.sigleton.Singleton;

/**
 * Created by GIOPPL
 * on 2022/7/7 21:48
 * TODO:
 */
public class Main {
    public static void main(String[] args) {
        Hunger hunger = Hunger.getInstance();
        Lazy lazy = Lazy.getInstance();
        EnumInstance enumInstance = EnumInstance.getInstance();
        System.out.println(enumInstance.getA(5, 10));
        Singleton singleton = Singleton.getInstance();

    }
}
