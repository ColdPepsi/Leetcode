import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/12 21:21
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 递归处理
     * @author WuBiao
     * @date 2020/3/12 21:46
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        //key为数组中的元素，value为以该元素为末尾的序列的长度
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int num : nums) {
            count.put(num, 1);//初始化为1，把当前自己看成1个连续的序列
        }
        for (int num : nums) {
            findLength(count, num);//每个元素都调用一遍findLength函数
        }
        return Collections.max(count.values());//返回最大值
    }

    /**
     * @param count
     * @param num
     * @return int
     * @description 递归寻找以num为末尾的序列长度
     * @author WuBiao
     * @date 2020/3/12 21:48
     */
    private int findLength(Map<Integer, Integer> count, int num) {
        if (!count.containsKey(num)) {
            //没有该键值，直接返回0
            return 0;
        }
        int cnt = count.get(num);
        if (cnt > 1) {
            //说明已经更新了她的值，直接返回更新后的结果就行
            return cnt;
        }
        //没有更新值的情况下，更新下面的操作
        cnt = findLength(count, num - 1) + 1;//找他前一个元素的值，找到后加1即可
        count.put(num, cnt);//更新count中的数据
        return cnt;//返回长度
    }
}