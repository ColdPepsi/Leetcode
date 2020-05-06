import java.util.PriorityQueue;

/**
 * @author WuBiao
 * @date 2020/4/28 20:06
 */
public class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;//len需要是k的倍数
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(len);
        for (int num : nums) {
            queue.offer(num);//把nums数组中的数全部放到优先队列中去
        }
        for (int i = 0; i < len / k; i++) {//每组有k个元素，一共划分len/k组
            int min = queue.poll();//队首元素出队
            for (int j = 1; j < k; j++) {//再出队k-1个元素
                if (queue.remove(min + j)) {//因为每组k个元素都是连续的
                    continue;
                }
                //如果移除失败，返回false
                return false;
            }
        }
        return true;
    }
}