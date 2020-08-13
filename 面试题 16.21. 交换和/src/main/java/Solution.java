/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 类Solution.java的实现描述：暴力搜索
 *
 * @author wubiao21 2020年08月12日 11:04:43
 */
public class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        Set<Integer> numSet1 = new HashSet<>(array1.length);
        Set<Integer> numSet2 = new HashSet<>(array2.length);
        for (int i : array1) {
            sum1 += i;
            numSet1.add(i);
        }
        for (int i : array2) {
            sum2 += i;
            numSet2.add(i);
        }
        int abs = Math.abs(sum1 - sum2);
        if (sum1 == sum2 || abs % 2 == 1) {//两个集合的差必须是偶数才行
            return new int[0];
        }
        int sub = abs / 2;
        //剩下的就是寻找，两个数组中有没有两个数相差是sub
        if (sum1 < sum2) {
            for (int i : array1) {
                if (numSet2.contains(i + sub)) {
                    return new int[]{i, i + sub};
                }
            }
        } else {
            for (int i : array2) {
                if (numSet1.contains(i + sub)) {
                    return new int[]{i + sub, i};
                }
            }
        }
        return new int[0];
    }
}