/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：摩尔投票法
 * 超过n/3的数最多只能有两个
 * A、B指的是出现次数最大的两个数，如果A、B都出现超过n/3,且每次都拿走每次都拿走3个不一样的数, 那么最后剩下的, 一定是A, B。
 * 具体的算法思想：https://leetcode-cn.com/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa-zui-zh/
 *
 * @author wubiao21 2020年10月10日 16:28:26
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            //初始化两个候选人和他们的计票
            int cand1 = nums[0], cand2 = nums[0];
            int count1 = 0, count2 = 0;
            //配对阶段
            for (int num : nums) {
                if (num == cand1) {
                    count1++;
                } else if (num == cand2) {
                    count2++;
                } else if (count1 == 0) {//出现不可抵消
                    cand1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    cand2 = num;
                    count2 = 1;
                } else {
                    //走到这说明出现不同投票，且可抵消
                    count1--;
                    count2--;
                }
            }
            //计数阶段，找到两个候选人之后，判断是否超过n/3;
            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == cand1) {
                    count1++;
                } else if (num == cand2) {
                    count2++;
                }
            }
            //把超过n/3的候选人加入到结果集
            if (count1 > nums.length / 3) {
                res.add(cand1);
            }
            if (count2 > nums.length / 3) {
                res.add(cand2);
            }
        }
        return res;
    }
}