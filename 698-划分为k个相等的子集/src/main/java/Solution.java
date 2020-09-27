/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 暴力回溯尝试每种可能
 *
 * @author wubiao21 2020年09月16日 09:37:48
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = 0;
        int max = -1;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % k != 0 || sum / k < max) {//如果不能平分k份或者每份和小于数组最大值，直接返回false
            return false;
        }
        boolean[] used = new boolean[nums.length];//used[i]表示nums下标为i的元素有没有被使用
        return backTracking(0, 0, nums, k, sum / k, used);
    }

    /**
     * 从num[index]开始能不能把数组分成相等的k等份
     *
     * @param index      其实下标
     * @param currentSum 当前子集的和
     * @param nums       数组
     * @param k          k等份
     * @param targetSum  目标和
     * @param used       表示某个值有没有被分配
     * @return 可以分配返回true
     */
    private boolean backTracking(int index, int currentSum, int[] nums, int k, int targetSum, boolean[] used) {
        if (k == 0) {//k等于0时候表示分配完毕，返回true
            return true;
        }
        if (currentSum == targetSum) {//满足条件时，说明分配了一个子集了，设置index==0;currentSum==0,k--;尝试分配下一个子集
            return backTracking(0, 0, nums, k - 1, targetSum, used);
        }
        for (int i = index; i < nums.length; i++) {//每次从index往后分配，避免重复用同一个子集
            if (!used[i] && currentSum + nums[i] <= targetSum) {//如果没有访问过这个数，并且把这个数加入到当前子集中和没有爆表
                used[i] = true;//尝试分配此元素
                if (backTracking(i + 1, currentSum + nums[i], nums, k, targetSum, used)) {//回溯后面，找个一个可行解就返回
                    return true;
                }
                used[i] = false;//恢复现场
            }
        }
        return false;
    }
}