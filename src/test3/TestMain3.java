package test3;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestMain3 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(32);
        set.add(2);
        set.remove(1);
        list = new ArrayList<>(set);
//        System.out.println(list);
        Object[] ints =  set.toArray();
        int[] ints1 = set.stream().sorted().mapToInt(num -> num).toArray();
        System.out.println(ints1[0]+","+ints1[1]);
    }
}
