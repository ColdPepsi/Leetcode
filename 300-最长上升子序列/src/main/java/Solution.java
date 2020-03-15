/**
 * @author WuBiao
 * @date 2020/3/15 17:15
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 动态规划，dp[i],代表以nums[i]为最后一个元素的最长递增序列。
     * dp[i]=max｛1，dp[j+1]｝,对于j<i，且nums[j]<nums[i]；
     * @author WuBiao
     * @date 2020/3/15 17:27
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;//代表自己是一个序列
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

    /**
     * @param nums 寻找的数组
     * @param len  nums长度
     * @param key  寻找的键值
     * @return int
     * @description 长度为len的nums数组中查找第一个大于等于key的下标
     * @author WuBiao
     * @date 2020/3/15 17:48
     */
    public int binarySearch(int[] nums, int len, int key) {
        int left = 0, right = len;//注意：这里的right应该为len,不是len-1,因为有可能key大于nums所有元素
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= key) {
                right = mid;//这里应该是mid，不是mid-1
            } else {//nums[mid]<key时候
                left = mid + 1;
            }
        }//left==right时候退出循环，找到此位置
        return left;
    }

    /**
     * @description 二分解法
     * @param nums
     * @author WuBiao
     * @return int
     * @date 2020/3/15 19:28
    */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];//tails[i]表示长度为i+1递增序列的尾部元素
        tails[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len - 1]) {//当前元素大于tails最后一个元素，则把它放到tails最后
                tails[len] = nums[i];
                len++;
            } else {//nums[i]<=tails[len-1]
                int index = binarySearch(tails, len, nums[i]);//找到tails中第一个大于等于nums[i]的下标
                tails[index] = nums[i];//把该元素换成它
            }
        }
        return len;
    }
}