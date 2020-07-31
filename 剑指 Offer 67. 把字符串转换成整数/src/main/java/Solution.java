/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月29日 09:54:52
 */
public class Solution {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left <= right && chars[left] == ' ') {
            left++;
        }
        if (left > right) {
            return 0;
        }
        boolean positive = true;
        if (chars[left] == '-') {
            left++;
            positive = false;
        } else if (chars[left] == '+') {
            left++;
        }
        long ret = 0;
        while (left <= right && Character.isDigit(chars[left])) {
            int digit = chars[left++] - '0';
            if (ret > (Integer.MAX_VALUE - digit) / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ret = ret * 10 + digit;
        }
        return positive ? (int) ret : -(int) ret;
    }
}