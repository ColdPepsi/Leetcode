/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * 类Solution.java的实现描述：找到区间内最大值索引，然后二分区间递归
 *
 * @author wubiao21 2020年09月09日 10:08:22
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = getMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, left, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, right);
        return root;
    }

    /**
     * 返回nums[left...right]区间内的最大值的索引下标
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int getMaxIndex(int[] nums, int left, int right) {
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }
}