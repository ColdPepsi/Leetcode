/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 手动暴力求解，模拟手工算乘法的过程，各位分别相乘
 *
 * @author wubiao21 2020年08月13日 11:21:05
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int iPower = 0;//i的权值，记录后面有几个0
        String ret = "";
        for (int i = chars1.length - 1; i >= 0; i--) {//乘数
            int jPower = 0;//j的权值，记录后面有几个0
            int iNum = (chars1[i] - '0');
            for (int j = chars2.length - 1; j >= 0; j--) {//被乘数
                int jNum = (chars2[j] - '0');
                StringBuilder value = new StringBuilder(String.valueOf(iNum * jNum));
                int totalZero = iPower + jPower;
                for (int k = 0; k < totalZero; k++) {//后面追加0
                    value.append('0');
                }
                ret = getSum(ret, value);
                jPower++;
            }
            iPower++;
        }
        return ret;
    }

    /**
     * 计算两个字符串相加的和
     *
     * @param ret
     * @param value
     * @return
     */
    private String getSum(String ret, StringBuilder value) {
        int index1 = ret.length() - 1;
        int index2 = value.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (carry != 0 || index1 >= 0 || index2 >= 0) {
            if (index1 >= 0) carry += ret.charAt(index1--) - '0';
            if (index2 >= 0) carry += value.charAt(index2--) - '0';
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}