import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by GIOPPL
 * on 2021/6/25 23:08
 * TODO:
 */
public class Test {

    public static void main(String[] args) {
        int[] num=new int[]{1,1,2};
        Map<Integer,Integer> map=new HashMap<>();
        ArrayList<ArrayList<Integer>> re=new  ArrayList<ArrayList<Integer>>();
        LinkedList<Integer> list=new LinkedList<Integer>();
        int[] t=new int[num.length];
        for(int i=0;i<num.length;i++){
            map.put(i,num[i]);
            t[i]=i;
        }
        List<List<Integer>> collect = re.stream().map(l -> l.stream().map(map::get).collect(Collectors.toList())).collect(Collectors.toList());
        collect.get(0).set(0,1);
    }

}
