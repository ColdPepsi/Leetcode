/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.TreeSet;

/**
 * 利用红黑树
 *
 * @author wubiao21 2020年07月17日 09:13:20
 */
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> numSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = numSet.ceiling(nums[i]);//找到第一个大于等于nums[i]的数
            if (ceiling != null && (double) ceiling - (double) nums[i] <= t) {
                return true;
            }
            Integer floor = numSet.floor(nums[i]);//找到第一个小于等于nums[i]的数
            if (floor != null && (double) nums[i] - (double) floor <= t) {
                return true;
            }
            numSet.add(nums[i]);//加入set
            if (numSet.size() > k) {//set里面最多放入k个元素
                numSet.remove(nums[i - k]);//去掉最先放入的元素
            }
        }
        return false;
    }
}