/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 类Solution.java的实现描述：把根root子树序列化字符串，如果存在重复的字符串就说明出现重复的子树
 *
 * @author wubiao21 2020年10月13日 10:17:54
 */
public class Solution {
    HashMap<String, Integer> memo;//记录每个序列化字符串出现的次数
    ArrayList<TreeNode> ret;//结果集

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        memo = new HashMap<>();
        ret = new ArrayList<>();
        postOrder(root);
        return ret;
    }

    private String postOrder(TreeNode root) {
        if (root == null) {
            return "#";//空指针占位符
        }
        String str = postOrder(root.left) + ',' + postOrder(root.right) + ',' + root.val;//以root为根结点后序遍历序列化字符串
        int count = memo.getOrDefault(str, 0);
        if (count == 1) {//如果已经该字符串已经出现过一次了，就加入到结果集
            ret.add(root);
        }
        memo.put(str, count + 1);
        return str;
    }
}