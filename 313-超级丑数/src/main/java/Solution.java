/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年09月28日 14:28:38
 */
public class Solution {
    /**
     * 模仿剑指offer49题写法即可，几个因子就设置几个指针
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] pointers = new int[primes.length];
        for (int i = 1; i < n; i++) {
            dp[i] = getMin(pointers, primes, dp);
        }
        return dp[n - 1];
    }

    private int getMin(int[] pointers, int[] primes, int[] dp) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < pointers.length; i++) {
            min = Math.min(min, dp[pointers[i]] * primes[i]);
        }
        for (int i = 0; i < pointers.length; i++) {
            if (min == dp[pointers[i]] * primes[i]) {
                pointers[i]++;
            }
        }
        return min;
    }
}