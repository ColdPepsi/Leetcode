/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月29日 11:34:46
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.trim().toCharArray();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                numFlag = true;
            } else if (chars[i] == '.') {
                if (dotFlag || eFlag) {
                    return false;
                }
                dotFlag = true;
            } else if (chars[i] == 'e') {
                if (eFlag || !numFlag) {
                    return false;
                }
                eFlag = true;
                numFlag = false;//重点
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i - 1] != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numFlag;
    }
}