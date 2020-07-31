/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution2.java的实现描述：尝试用下一个排列来解决,第31题的思想
 *
 * @author wubiao21 2020年07月30日 18:04:34
 */
public class Solution2 {
    public String[] permutation(String S) {
        int times = factorial(S.length());//计算要生成多少个排列
        List<String> res = new ArrayList<>(times);
        char[] chars = S.toCharArray();
        for (int i = 0; i < times; i++) {
            getNextPermutation(chars);//重复生成下一个排列，并加入到结果集
            res.add(String.valueOf(chars));
        }
        int index = 0;
        String[] ret = new String[res.size()];
        for (String str : res) {
            ret[index++] = str;
        }
        return ret;
    }

    /**
     * 计算x的阶乘
     *
     * @param x
     * @return
     */
    private int factorial(int x) {
        return x == 0 || x == 1 ? 1 : x * factorial(x - 1);
    }

    /**
     * 交换chars[i]与chars[j]
     *
     * @param chars
     * @param i
     * @param j
     */
    private void swap(char[] chars, int i, int j) {
        chars[i] += chars[j];
        chars[j] = (char) (chars[i] - chars[j]);
        chars[i] -= chars[j];
    }

    /**
     * 翻转chars[left...right]
     *
     * @param chars 字符数组
     * @param left  区间左端点
     * @param right 区间右端点
     */
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
    }

    /**
     * 生成chars的下一个排列
     *
     * @param chars
     */
    private void getNextPermutation(char[] chars) {
        int len = chars.length;
        int i = len - 1;
        while (i > 0 && chars[i - 1] >= chars[i]) {//找第一个递增对（i-1,i）
            i--;
        }
        if (i != 0) {//i==0说明整体降序
            int j = len - 1;
            while (j >= i && chars[j] <= chars[i - 1]) {
                j--;
            }
            swap(chars, i - 1, j);
        }
        reverse(chars, i, len - 1);
    }
}