/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：前缀和+哈希表
 * 把数组中所有的0看成-1，如果一个区间的和是0，则说明区间里0和1的数量相同
 *
 * @author wubiao21 2020年09月29日 15:25:49
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> position = new HashMap<>(len);//记录某个前缀和出现的最早位置
        int res = 0;
        int preSum = 0;//前缀和
        position.put(0, -1);//前缀和0出现在索引-1处，主要用来计算。
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {//当前元素是1，则加上当前元素
                preSum++;
            } else {//否则加上-1；
                preSum--;
            }
            if (position.containsKey(preSum)) {//如果之前存在了该前缀和，就计算区间区间长度
                res = Math.max(res, i - position.get(preSum));
            } else {
                position.put(preSum, i);
            }
        }
        return res;
    }
}