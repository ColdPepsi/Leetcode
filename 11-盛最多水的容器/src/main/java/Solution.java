/**
 * @author WuBiao
 * @date 2020/4/18 13:11
 */
public class Solution {
    /**
     * @param height
     * @return int
     * @description 双指针法
     * @author WuBiao
     * @date 2020/4/18 13:16
     */
    public int maxArea(int[] height) {
        int left = 0;
        int rigth = height.length - 1;
        int max = 0;
        while (left < rigth) {
            max = Math.max(max, Math.min(height[left], height[rigth]) * (rigth - left));
            if (height[left] > height[rigth]) {//移动指向数字较小的指针
                rigth--;
            } else {
                left++;
            }
        }
        return max;
    }
}