package test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by GIOPPL
 * on 2022/7/2 23:55
 * TODO:
 */
public class MyTest implements  Serializable {
    private static final long serialVersionUID = 1749243243491717954L;//具体数值自己定义
    private Integer id;
    private String name;
    private Date birthday;
    private static String address = "China";//默认情况下，静态属性不会被序列化

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getAddress() {
        return address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setAddress(String address) {
        MyTest.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
