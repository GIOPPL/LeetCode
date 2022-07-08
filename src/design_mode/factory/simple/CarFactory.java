package design_mode.factory.simple;

/**
 * Created by GIOPPL
 * on 2022/7/7 23:01
 * TODO:
 */
public class CarFactory {
    public static Car getCar(String car){
        if(car.equals("五菱")){
            return new Wulin();
        }else if (car.equals("特斯拉")){
            return new Tesla();
        }
        return null;
    }
}
