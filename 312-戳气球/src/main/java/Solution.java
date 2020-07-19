/**
 * 分治解法
 *
 * @author WuBiao
 * @date 2020/7/19 22:22
 */
public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] nums2 = new int[len + 2];
        System.arraycopy(nums, 0, nums2, 1, len);
        nums2[0] = 1;//给原数组加上两个边界，因为我们定义的是开区间，所以加上边界之后就可以把区间传进去计算
        nums2[len + 1] = 1;
        len = nums2.length;
        int[][] memo = new int[len][len];
        return maxCoins(nums2, 0, len - 1, memo);
    }

    /**
     * @param nums  数组
     * @param start 区间左端点
     * @param end   区间右端点
     * @param memo  记忆化数组，避免重复计算
     * @return int
     * @description maxCoins(start, end)表示戳破 nums（start，end）的气球获得的最多的金币，不包含边界start与end
     * @author WuBiao
     * @date 2020/7/19 22:41
     */
    private int maxCoins(int[] nums, int start, int end, int[][] memo) {
        if (start + 1 == end) {//边界，区间（start,start+1）表示区间中没有气球了，返回0
            return 0;
        }
        if (memo[start][end] != 0) {//已经存在计算过的值，直接返回
            return memo[start][end];
        }
        int max = 0;//保存最大值
        for (int index = start + 1; index < end; index++) {//分治法，尝试(start,end)中的每个点
            //戳破（start,index）,(index,end)后，只剩下3个点，start,index,end，戳破index后得到金币nums[start] * nums[index] * nums[end]
            int temp = maxCoins(nums, start, index, memo) + maxCoins(nums, index, end, memo) + nums[start] * nums[index] * nums[end];
            if (temp > max) {
                max = temp;
            }
        }
        memo[start][end] = max;
        return max;
    }
}