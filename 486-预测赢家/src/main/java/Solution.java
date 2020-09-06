/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：递归
 *
 * @author wubiao21 2020年09月01日 13:40:20
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return maxScore(nums, 0, nums.length - 1) >= 0;
    }

    /**
     * 计算先手比后手多得多少分
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int maxScore(int[] nums, int left, int right) {
        if (left == right) {//如果只有一个元素，先手直接取这个元素获胜
            return nums[left];
        }
        int pickLeft = nums[left] - maxScore(nums, left + 1, right);//如果先手取当前最左边的元素，在剩下的元素中[left+1...right]后手相当于先手，可以直接调用递归
        int pickRight = nums[right] - maxScore(nums, left, right - 1);//同理是先手取最右边的元素
        return Math.max(pickLeft, pickRight);//返回先手的最大选择
    }
}