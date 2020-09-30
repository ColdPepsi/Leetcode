/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类Solution.java的实现描述：后序遍历
 *
 * @author wubiao21 2020年09月30日 09:11:07
 */
public class Solution {

    private int ans = 0;

    public int countPairs(TreeNode root, int distance) {
        postOrder(root, distance);
        return ans;
    }

    /**
     * 后续遍历，返回一个列表，包含root结点到其下方所有叶子结点的距离。
     *
     * @param root
     * @param distance
     * @return
     */
    private List<Integer> postOrder(TreeNode root, int distance) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (isLeaf(root)) {//如果root是叶子结点，返回一个列表，只有1个元素0，表示自身到叶子结点的距离是0，自己就是叶子结点
            return Collections.singletonList(0);
        }
        List<Integer> left = postOrder(root.left, distance);//获取左子树的叶子结点距离
        List<Integer> right = postOrder(root.right, distance);//获取右子树的叶子结点距离
        List<Integer> list = new ArrayList<>(left.size() + right.size());//用来存放左右两个子树所有的叶子结点距离
        for (Integer dis : left) {
            if (++dis < distance) {//每个距离要加1，因为列表中的距离是自己孩子到叶子结点的距离。如果大于等于distance就跳过
                list.add(dis);
            }
        }
        for (Integer dis : right) {
            if (++dis < distance) {
                list.add(dis);
            }
        }
        for (int l : left) {//如果左右子树中有结点对距离和没超过distance，结果加1；
            for (int r : right) {
                if (l + r + 2 <= distance) {
                    ans++;
                }
            }
        }
        return list;//返回list
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}