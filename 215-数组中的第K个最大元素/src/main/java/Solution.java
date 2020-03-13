import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/3/13 12:40
 */
public class Solution {
    /**
     * @param nums
     * @param k
     * @return int
     * @description 使用一个小根堆
     * @author WuBiao
     * @date 2020/3/13 12:46
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();//建立一个小根堆
        for (int num : nums) {
            pq.offer(num);//每个元素都入队
            if (pq.size() > k) {
                pq.poll();//保持pq.size()始终等于k，所有元素入队后，最后对顶元素就是第K最大元素
            }
        }
        return pq.peek();
    }
}