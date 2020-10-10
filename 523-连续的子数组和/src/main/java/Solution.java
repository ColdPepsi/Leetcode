/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;

/**
 * 类Solution.java的实现描述：hashmap+前缀和的应用
 *
 * @author wubiao21 2020年10月10日 13:49:38
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, -1);//初始化，因为nums[i....j]的和等于preSum[j]-preSum[i-1]，i==0时候，把-1先加入，主要用于计算
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];//计算前缀和
            if (k != 0) {
                preSum %= k;//对preSum取余
            }
            if (map.containsKey(preSum)) {
                if (i - map.get(preSum) > 1) {//判断集合内的个数
                    return true;
                }
            } else {
                map.put(preSum, i);
            }
        }
        return false;
    }
}