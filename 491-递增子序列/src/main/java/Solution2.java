/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类Solution2.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年08月25日 17:52:37
 */
public class Solution2 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(nums.length * nums.length);
        if (nums.length >= 2) {
            backTracking(0, nums, new ArrayList<>(), new boolean[nums.length], res);
        }
        return res;
    }

    private void backTracking(int index, int[] nums, ArrayList<Integer> prefix, boolean[] visited, List<List<Integer>> res) {
        if (prefix.size() >= 2) {
            res.add(new ArrayList<>(prefix));
        }
        if (index >= nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();//保证同一层的数，只加入一次，起到去重的效果
        for (int i = index; i < nums.length; i++) {
            if (visited[i] || set.contains(nums[i])) {
                continue;
            }
            if (prefix.isEmpty() || nums[i] >= prefix.get(prefix.size() - 1)) {
                visited[i] = true;
                prefix.add(nums[i]);
                set.add(nums[i]);//加入到set中，表示本层已经访问了nums[i];
                backTracking(i + 1, nums, prefix, visited, res);
                prefix.remove(prefix.size() - 1);
                visited[i] = false;
            }
        }
    }
}