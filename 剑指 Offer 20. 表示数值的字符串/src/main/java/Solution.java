/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月29日 10:53:53
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.trim().toCharArray();//去掉前后空格
        boolean numFlag = false;//表示数字有没有出现
        boolean dotFlag = false;//小数点有没有出现
        boolean eFlag = false;//e有没有出现
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                numFlag = true;
            } else if (chars[i] == '.') {
                //小数点之前不能出现e和小数点
                if (dotFlag || eFlag) {
                    return false;
                }
                dotFlag = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                //e之前必须出现数字和不能有e
                if (!numFlag || eFlag) {
                    return false;
                }
                eFlag = true;
                numFlag = false;//这句是重点，开始判断e后面的数，保证e后面也出现数字
            } else if (chars[i] == '+' || chars[i] == '-') {
                //正负号只能出现在第一位或e后面
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numFlag;
    }
}