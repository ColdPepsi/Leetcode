/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution2.java的实现描述：前缀和+回溯
 *
 * @author wubiao21 2020年09月10日 09:09:07
 */
public class Solution2 {

    private int res = 0;//保存结果

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSumCount = new HashMap<>();//保存前缀和出现的次数，key是前缀和，value是次数
        preSumCount.put(0, 1);//初始化前缀和0出现1次，即什么结点也不选
        dfs(root, sum, 0, preSumCount);
        return res;
    }

    private void dfs(TreeNode root, int target, int currentSum, Map<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;//currentSum记录根节点到当前结点的路径和
        res += preSum.getOrDefault(currentSum - target, 0);//看curtrrentSum - target这个路径和出现几次，因为current和currentSum - target路径和之差就是target
        preSum.put(currentSum, preSum.getOrDefault(currentSum, 0) + 1);//更新currentSum出现的次数
        dfs(root.left, target, currentSum, preSum);//递归处理左右孩子
        dfs(root.right, target, currentSum, preSum);
        preSum.put(currentSum, preSum.get(currentSum) - 1);//因为要返回上层，所以currentSum的次数要减1，相当于回溯恢复现场
    }
}