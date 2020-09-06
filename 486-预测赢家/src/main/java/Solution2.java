/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：记忆化搜索，思想和solution一样，只不过加了记忆化，避免重复计算
 *
 * @author wubiao21 2020年09月01日 14:21:01
 */
public class Solution2 {

    private Integer[][] memo;

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        memo = new Integer[len][len];
        return maxScore(nums, 0, nums.length - 1) >= 0;
    }

    private int maxScore(int[] nums, int left, int right) {
        if (left == right) {
            memo[left][right] = nums[left];
            return nums[left];
        }
        if (memo[left][right] == null) {
            int pickLeft = nums[left] - maxScore(nums, left + 1, right);//如果先手取当前最左边的元素，在剩下的元素中[left+1...right]后手相当于先手，可以直接调用递归
            int pickRight = nums[right] - maxScore(nums, left, right - 1);//同理是先手取最右边的元素
            memo[left][right] = Math.max(pickLeft, pickRight);
        }
        return memo[left][right];
    }
}