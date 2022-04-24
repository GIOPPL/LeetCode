package test2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class BM50 {
    public static void main(String[] args) {
        BM50 b=new BM50();
        int[] ints = b.twoSum(new int[]{3, 2, 4}, 6);
        Arrays.stream(ints).forEach(System.out::println);
    }
    public int[] twoSum (int[] num, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i],i);
        }
        List<Integer> list= Arrays.stream(num).boxed().sorted().collect(Collectors.toList());
        int j=num.length-1,i=0;
        while(target<list.get(j)){
            j--;
        }

        for(;i<j;j--){
            while(list.get(i)+list.get(j)<target){
                i++;
                if(list.get(i)+list.get(j)==target){
                    return new int[]{map.get(list.get(i)),map.get(list.get(j))};
                }else if(list.get(i)+list.get(j)>target){
                    break;
                }
            }

        }
        return null;
    }
}
