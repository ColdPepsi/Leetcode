/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：二分快速幂
 *
 * @author wubiao21 2020年07月24日 13:53:08
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double absx = Math.abs(x);
        long absn = Math.abs(n);
        //下面这部分特殊情况直接参考的jdk1.8 StrictMath#pow()
        if (absx > 1 && n == Integer.MAX_VALUE || absx < 1 && n == Integer.MIN_VALUE || x == 0 && n < 0 || x == Integer.MAX_VALUE && n > 0) {
            return Integer.MAX_VALUE;
        }
        if (absx > 1 && n == Integer.MIN_VALUE || absx < 1 && n == Integer.MAX_VALUE || x == 0 && n > 0 || x == Integer.MAX_VALUE && n < 0) {
            return 0;
        }
        //下面二分快速幂
        double half = myPow(x, (int) absn / 2);
        double res = half * half;
        if ((absn & 1) == 1) {
            res *= x;
        }
        return absn == n ? res : 1.0 / res;
    }
}