/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import entity.TreeNode;

/**
 * @author wubiao21 2020年09月02日 11:55:37
 */
public class Solution {

    private TreeNode deletedFather = null;//指向要被删除的结点的父结点

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {//如果要删除根结点
            if (root.left == null && root.right == null) {//如果根结点左右孩子为空，直接返回null
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode temp = root.right;//找根结点右孩子最左边的元素
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = root.left;//root的左孩子拼接到temp.left
            return root.right;//返回根节点的右孩子
        } else {
            if (!find(root, key)) {//如果没有找到要删除的结点，直接返回根节点
                return root;
            }
            if (deletedFather.left != null && deletedFather.left.val == key) {//如果deleteFather的左孩子指向要删除结点
                if (deletedFather.left.left == null && deletedFather.left.right == null) {
                    deletedFather.left = null;//如果deleteFather的左孩子是叶子结点，直接把它置空
                    return root;
                }
                if (deletedFather.left.left == null) {
                    deletedFather.left = deletedFather.left.right;
                    return root;
                }
                if (deletedFather.left.right == null) {
                    deletedFather.left = deletedFather.left.left;
                    return root;
                }
                TreeNode temp1 = deletedFather.left.right;//因为要删除deletedFather.left，把deletedFather.left.left挂到deletedFather.left.right的最左边
                while (temp1.left != null) {
                    temp1 = temp1.left;
                }
                temp1.left = deletedFather.left.left;
                deletedFather.left = deletedFather.left.right;
                return root;
            } else {//这种情况跟上面是反过来的，deleteFather的右孩子指向要删除结点
                if (deletedFather.right.left == null && deletedFather.right.right == null) {
                    deletedFather.right = null;
                    return root;
                }
                if (deletedFather.right.right == null) {
                    deletedFather.right = deletedFather.right.left;
                    return root;
                }
                if (deletedFather.right.left == null) {
                    deletedFather.right = deletedFather.right.right;
                    return root;
                }
                TreeNode temp1 = deletedFather.right.right;
                while (temp1.left != null) {
                    temp1 = temp1.left;
                }
                temp1.left = deletedFather.right.left;
                deletedFather.right = deletedFather.right.right;
                return root;
            }
        }
    }

    /**
     * 找到要删除的结点，用deletedFather指向被删除结点的父结点
     *
     * @param root
     * @param key
     * @return
     */
    private boolean find(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.left != null && root.left.val == key || root.right != null && root.right.val == key) {
            deletedFather = root;
            return true;
        }
        if (find(root.left, key)) {
            return true;
        }
        return find(root.right, key);
    }
}