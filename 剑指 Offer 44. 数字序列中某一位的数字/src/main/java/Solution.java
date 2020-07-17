/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 同400题
 *
 * @author wubiao21 2020年07月17日 16:15:52
 */
public class Solution {
    public int findNthDigit(int n) {
        n--;
        for (int digit = 1; digit < 11; digit++) {
            long firstNum = (int) Math.pow(10, digit - 1);
            long len = 9 * firstNum * digit;//区间长度
            if (n < len) {
                return String.valueOf(firstNum + n / digit).charAt(n % digit) - '0';
            }
            n -= len;
        }
        return 0;
    }
}