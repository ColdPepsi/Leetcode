/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：此题丑数定义有所改变。二分查找，具体思路
 * https://leetcode-cn.com/problems/ugly-number-iii/solution/er-fen-fa-si-lu-pou-xi-by-alfeim/
 *
 * @author wubiao21 2020年09月30日 17:24:35
 */
public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(ab, c);
        long left = 1;
        long right = 2 * (long) (1E9);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;//容斥定理
            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    /**
     * 求a和b最大公因数
     *
     * @param a
     * @param b
     * @return
     */
    private long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    /**
     * 求a和b的最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}