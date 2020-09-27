/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年09月15日 19:37:38
 */
public class Solution2 {
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int max = A[0];//保存A[0..i]的最大值
        int pos = 0;//左区间[0,pos]
        int leftMax = A[0];//保存左区间[0,pos]的最大值
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            if (leftMax > A[i]) {//如果左区间的最大值大于当前值，肯定不能从当前值开始分，当前值应该纳入左区间
                leftMax = max;//更新leftMax
                pos = i;//pos扩张到i
            }
        }
        return pos + 1;
    }
}