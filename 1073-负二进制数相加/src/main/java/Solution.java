/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 2 * (-2)^n = (-1) * (-2)^(n+1) = (-2)^(n+1)+(-2)^(n+2)
 * 两种进位方式，向前面进-1，或者向前面两位都进 1
 *
 * @author wubiao21 2020年08月19日 13:47:06
 */
public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int carry = 0;
        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;
        StringBuilder res = new StringBuilder(Math.max(index1, index2) + 4);//保存相加的结果，嫌慢可以换成数组，不是重点
        while (carry != 0 || index1 >= 0 || index2 >= 0) {
            if (index1 >= 0) {
                carry += arr1[index1--];
            }
            if (index2 >= 0) {
                carry += arr2[index2--];
            }
            //carry此时会有5种可能，-1，0，1，2，3
            switch (carry) {
                case -1://如果相加后和为-1，说明arr1和arr2相应的位都是0，carry前一位的进位是-1，然后相加得到了-1
                    res.append("1");//结果集中加入1
                    carry = 1;//carry置1，相当与我们把前面的进位-1，改成了进两位1
                    break;
                case 0:
                case 1:
                    res.append(carry);//此时没有进位，直接追加结果即可
                    carry = 0;
                    break;
                case 2:
                case 3:
                    res.append(carry - 2);
                    carry = -1;//向前一位进位-1
                    break;
            }
        }
        //下面的就是组装结果，与算法无关
        char[] chars = res.reverse().toString().toCharArray();//翻转字符串
        int index = 0;
        while (index < chars.length && chars[index] == '0') {
            index++;//找到第一个非0的位
        }
        if (index == chars.length) {//说明全是0，返回0
            return new int[]{0};
        }
        int[] ret = new int[chars.length - index];//拷贝结果
        for (int i = index; i < chars.length; i++) {
            ret[i - index] = chars[i] - '0';
        }
        return ret;
    }
}