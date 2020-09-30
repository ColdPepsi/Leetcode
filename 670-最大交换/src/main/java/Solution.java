/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：不用排序，贪心思想，找第一大数，放在前面
 *
 * @author wubiao21 2020年09月30日 10:21:01
 */
public class Solution {
    public int maximumSwap(int num) {
        if (num <= 10) {
            return num;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int[] lastPosition = new int[10];
        for (int i = 0; i < chars.length; i++) {//记录每个数字最后出现的位置
            lastPosition[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - '0';
            for (int d = 9; d > number; d--) {//如果数d大于当前字符，并且d在后面会出现，则把d和位置i的字符交换，并返回结果
                if (lastPosition[d] > i) {
                    char temp = chars[i];
                    chars[i] = (char) (d + '0');
                    chars[lastPosition[d]] = temp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}