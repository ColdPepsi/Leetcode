/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：暴力求解
 *
 * @author wubiao21 2020年09月15日 19:24:15
 */
public class Solution {
    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] leftToRightMax = new int[len];//leftToRightMax[i]表示A[0...i]的最大值
        int[] rightToLeftMin = new int[len];//rightToLeftMin[i]表示A[i...len-1]的最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = len - 1; i < len; i++, j--) {//求最大值最小值
            max = Math.max(max, A[i]);
            leftToRightMax[i] = max;
            min = Math.min(min, A[j]);
            rightToLeftMin[j] = min;
        }
        for (int i = 1; i < len; i++) {
            if (rightToLeftMin[i] >= leftToRightMax[i - 1]) {
                return i;//左区间为[0,i-1]长度为i
            }
        }
        return 0;//题目保证有解，不会执行到这一句
    }
}