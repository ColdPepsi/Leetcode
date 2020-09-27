/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述:公式(A[i]+i)+(A[j]-j),对于每个元素(A[j]-j)是固定的，只要求得前面最大的A[i]+i即可
 *
 * @author wubiao21 2020年09月17日 09:11:45
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxI = A[0];//保存最大的A[i]+i
        int res = -1;
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, A[i] - i + maxI);
            maxI = Math.max(maxI, A[i] + i);
        }
        return res;
    }
}