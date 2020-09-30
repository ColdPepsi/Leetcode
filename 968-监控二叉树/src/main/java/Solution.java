/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

/**
 * 类Solution.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年09月27日 11:54:36
 */
public class Solution {
    private int res = 0;

    /**
     * 每个节点有3种状态，用3个数字表示3种状态
     * 0：该节点无覆盖
     * 1：本节点有摄像头
     * 2：本节点有覆盖
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        if (postOrder(root) == 0) {//如果处理完，根节点还是无覆盖，则需要在根节点装摄像头
            res++;
        }
        return res;
    }

    /**
     * 后序遍历，返回当前结点的状态
     *
     * @param root
     * @return
     */
    private int postOrder(TreeNode root) {
        /*为了让摄像头数量最少，我们要尽量让叶子节点的父节点安装摄像头，这样才能摄像头的数量最少。
        那么空节点不能是无覆盖的状态，这样叶子节点就可以放摄像头了，空节点也不能是有摄像头的状态，这样叶子节点的父节点就没有必要放摄像头了，而是可以把摄像头放在叶子节点的爷爷节点上。
        所以空节点的状态只能是有覆盖，这样就可以在叶子节点的父节点放摄像头了*/
        if (root == null) {
            return 2;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        if (left == 2 && right == 2) {//左右孩子均有覆盖
            return 0;
        }
        if (left == 0 || right == 0) {//左右孩子有一个没有覆盖，在应该在此节点放置摄像头
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {//左右孩子有一个有摄像头
            return 2;
        }
        return -1;//不会走到这一句
    }
}

    