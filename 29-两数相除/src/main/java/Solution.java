/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
 *
 * @author wubiao21 2020年10月09日 11:36:46
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        if (divisor == 1 || dividend == 0) {
            return dividend;
        }
        int sign = 1;//表示符号
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {//异号
            sign = -1;
        }
        dividend = dividend > 0 ? -dividend : dividend;//转成负号计算，因为Integer.MIN_VALUE转成正值会溢出
        divisor = divisor > 0 ? -divisor : divisor;
        int ans = div(dividend, divisor);
        return sign == -1 ? -ans : ans;
    }

    private int div(int dividend, int divisor) {
        if (dividend > divisor) {//递归边界，比如-2/-3这时候应该等于0
            return 0;
        }
        int count = 1;
        int temp = divisor;
        //temp + temp < 0用来判断溢出，temp是负数，如果溢出的话temp+temp会大于等于0
        while (temp + temp >= dividend && temp + temp < 0) {
            temp += temp;
            count += count;
        }
        return count + div(dividend - temp, divisor);
    }
}