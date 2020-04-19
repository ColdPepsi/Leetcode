/**
 * @author WuBiao
 * @date 2020/4/19 10:28
 */
public class Solution {
    /**
     * @param height
     * @return int
     * @description 双指针
     * @author WuBiao
     * @date 2020/4/19 10:42
     */
    public int trap(int[] height) {
        int left = 0;//从左往右遍历的下标
        int leftMax = 0;//从左往右数的最大值，也就是下标left左边的最大值
        int right = height.length - 1;//从右往左遍历的下标
        int rightMax = 0;//从右往左数的最大值，下标right右边的最大值
        int res = 0;
        //一个点能接多少雨水，取决于他左右最大值的较小值
        while (left <= right) {//要小于等于，计算出每个坐标能盛多少水
            if (leftMax < rightMax) {
                res += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(height[left], leftMax);
                left++;
            } else {
                res += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
        }
        return res;
    }
}