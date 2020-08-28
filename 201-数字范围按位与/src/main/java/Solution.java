/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：暴力解
 *
 * @author wubiao21 2020年08月24日 11:39:07
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int res = m;
        for (int i = m + 1; i <= n && i != Integer.MIN_VALUE; i++) {
            res &= i;
            if (res == 0) {
                return res;
            }
        }
        return res;
    }
}