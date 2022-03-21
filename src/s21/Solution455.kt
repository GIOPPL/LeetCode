package s21

import java.util.*

/**
 * Created by GIOPPL
 * on 2021/6/29 16:20
 * TODO:[贪心]有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩子可以吃饱。
    给定  g为孩子的饥饿度，s为饼干数量，只有g[x]>s[y]的时候，孩子才能吃饱
    示例：
        输入: g = [1,2,3], s = [1,1]
        输出: 1
    解析：
        贪心算法
        先将g和s从小到大排序
        再遍历饼干，如果遇到可以满足条件的饼干，则需要给那个孩子吃，也就是re++
        如果孩子已经都吃完了，那么需要直接返回
 */
class Solution455 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val startTime = System.nanoTime() //获取开始时间
            start()
            val endTime = System.nanoTime() //获取结束时间
            print("程序运行时间：" + (endTime - startTime) / 1000 + "k ns")
        }

        private fun start() {
            val solution455 = Solution455()
            val g = intArrayOf(1, 2)
            val s = intArrayOf(1, 2, 3)
            println(solution455.findContentChildren(g, s))
        }
    }
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        //如果有一个是空的，那么将直接返回
        if (s.isEmpty() || g.isEmpty()) {
            return 0
        }
        //给两个数组都进行排序，好执行贪心算法
        Arrays.sort(g)
        Arrays.sort(s)
        //返回值
        var re = 0
        //饼干的迭代index
        var i = 0
        //小孩的迭代index
        var j = 0
        while (i < s.size) {
            //如果饼干可以满足小孩，那么re++
            if (j < g.size && g[j] <= s[i]) {
                j++
                re++
            }
            //如果小孩全部都喂饱了，直接返回
            if (j >= g.size) {
                return re
            }
            i++
        }
        return re
    }


}