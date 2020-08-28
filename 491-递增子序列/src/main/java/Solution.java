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
 * 类Solution.java的实现描述：所有解，直接回溯
 * 重点是如何去重，使用字符串哈希算法：两个字符串 ss 和 tt 相等，当且仅当它们的长度相等且编码值相等。
 *
 * @author wubiao21 2020年08月25日 09:16:10
 */
public class Solution {

    private static final int BASE = 263;
    private static final int MOD = (int) (1E9) + 7;

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(nums.length * nums.length);
        if (nums.length >= 2) {
            backTracking(0, nums, new ArrayList<>(), new boolean[nums.length], res, new HashSet<>(nums.length * nums.length));
        }
        return res;
    }

    private void backTracking(int index, int[] nums, ArrayList<Integer> prefix, boolean[] visited, List<List<Integer>> res, Set<Integer> set) {
        int hashCode = getHashCode(prefix);
        if (prefix.size() >= 2 && !set.contains(hashCode)) {
            res.add(new ArrayList<>(prefix));
            set.add(hashCode);
        }
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (prefix.isEmpty() || nums[i] >= prefix.get(prefix.size() - 1)) {
                visited[i] = true;
                prefix.add(nums[i]);
                backTracking(i + 1, nums, prefix, visited, res, set);
                prefix.remove(prefix.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 计算哈希值
     *
     * @param prefix
     * @return
     */
    private int getHashCode(ArrayList<Integer> prefix) {
        int hashCode = 0;
        for (int integer : prefix) {
            hashCode = hashCode * BASE % MOD + (integer + 101);//因为数的范围是[-100,100]，+101映射成正区间
            hashCode %= MOD;
        }
        return hashCode;
    }
}