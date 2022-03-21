package s21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2021/7/1 21:56
 * TODO:【贪心】【中等】假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
    每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，
    其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
    解析：
        1.排序，按身高从大到小排，如果身高一样，那么按k值从小到大排序
        2.按k值插入到list中
 */
public class Solution406 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        int[][] a1 = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] a2 = new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        int[][] a3 = new int[][]{{1, 0}, {2, 0}};

        Solution406 solution406 = new Solution406();
        int[][] b = solution406.reconstructQueue(a1);
        for (int[] ints : b) {
            System.out.println("(" + ints[0] + "," + ints[1] + ")\t");
        }
        System.out.println();
    }

    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        if (people.length == 0) {
            return new int[][]{};
        }
        //排序，按身高从大到小排，如果身高一样，那么按k值从小到大排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        //直接按K值插入到List中
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }
}
