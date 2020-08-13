/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类Solution.java的实现描述：暴力遍历
 *
 * @author wubiao21 2020年08月12日 11:32:49
 */
public class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(nums.length / 2);
        Map<Integer, Integer> count = new HashMap<>(nums.length);
        for (int num : nums) {//记录每个数出现的次数
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int time = count.getOrDefault(num, 0);//先看当前的数还剩下几次
            if (time == 0) {
                continue;
            }
            count.put(num, time - 1);//先减去1，防止target==2*num,这样的话一会查询的还是它
            int left = target - num;//看看剩下需要多少
            Integer exist = count.getOrDefault(left, 0);//看看需要的数存在不存在
            if (exist != 0) {//如果存在
                res.add(Arrays.asList(num, left));//加入结果集
                count.put(left, exist - 1);
            } else {//不存在的话，就恢复num的计数
                count.put(num, time);
            }
        }
        return res;
    }
}