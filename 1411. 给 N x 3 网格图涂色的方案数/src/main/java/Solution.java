/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年08月03日 09:46:14
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int numOfWays(int n) {
        if (n == 0) {
            return 0;
        }
        //每层的涂色可以分成ABA和ABC两类
        long ABA = 6;
        long ABC = 6;
        for (int i = 2; i <= n; i++) {
            //本层的每个ABA类 -> 下层演化为3个ABA+2个ABC
            //本层的每个ABC类 -> 下层演化为2个ABA+2个ABC
            ABC = 2 * (ABA + ABC) % MOD;
            ABA = (ABC + ABA) % MOD;
        }
        return (int) ((ABA + ABC) % MOD);
    }
}
/*算法思想来自
https://leetcode-cn.com/problems/number-of-ways-to-paint-n-x-3-grid/solution/shu-xue-jie-jue-fei-chang-kuai-le-by-lindsaywong
*/