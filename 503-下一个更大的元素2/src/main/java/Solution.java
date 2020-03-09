import java.util.Arrays;
import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/9 22:14
 */
public class Solution {
    /**
     * @param nums
     * @return int[]
     * @description 思想类似739题
     * @author WuBiao
     * @date 2020/3/9 22:41
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);//先全初始化-1
        Stack<Integer> stack = new Stack<Integer>();//存放每个没找到比它大的元素的下标
        for (int i = 0; i < n * 2; i++) {//因为是循环数组，需要遍历两边
            int currentNum = nums[i % n];//获取当前处理的元素
            while (!stack.isEmpty() && currentNum > nums[stack.peek()]) {
                res[stack.pop()] = currentNum;
            }
            if (i < n) {
                stack.push(i);//每个元素只入栈一次
            }
        }
        return res;
    }
}