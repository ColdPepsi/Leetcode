/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类BSTIterator.java的实现描述：暴力遍历即可
 *
 * @author wubiao21 2020年09月01日 15:06:40
 */
public class BSTIterator {

    private List<Integer> nums;
    private int currentIndex = -1;

    public BSTIterator(TreeNode root) {
        nums = new ArrayList<>();
        inOrder(root);
        if (!nums.isEmpty()) {
            currentIndex = 0;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return nums.get(currentIndex++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return currentIndex != -1 && currentIndex < nums.size();
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            nums.add(root.val);
            inOrder(root.right);
        }
    }
}