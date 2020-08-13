/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类Solution2.java的实现描述：官方题解
 * https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
 * <p>
 * 把拼接成的回文串看成s1+s2,
 * 如果len1==len2，s1是s2的翻转
 * 如果len1>len2,则s1可以分割成t1+t2,其中t2是回文，t1是s2的翻转
 * 如果len1<len2,则s2可以分割成t1+t2,其中t1是回文，t2是s1的翻转
 * <p>
 * 然后遍历字符数组，把每个字符都当较长的字符串，分别看满足那种那种情况
 *
 * @author wubiao21 2020年08月06日 16:10:03
 */
public class Solution2 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<String> wordReverse = new ArrayList<>(words.length);
        Map<String, Integer> index = new HashMap<>(words.length);
        for (String word : words) {
            wordReverse.add(new StringBuilder(word).reverse().toString());
        }
        for (int i = 0; i < wordReverse.size(); i++) {
            index.put(wordReverse.get(i), i);
        }
        List<List<Integer>> res = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            if (len == 0) {
                continue;
            }
            for (int j = 0; j <= len; j++) {//j可以等于len是为了判断情况1，回文串既可以拼接成s1+s2也可以拼接成s2+s1
                if (palindrome(word, j, len - 1)) {//[j...len-1]是回文，符合情况2，word是s1，回文部分是t2，下面看看存不存在[0...j-1]的翻转
                    int leftIndex = index.getOrDefault(word.substring(0, j), -1);
                    if (leftIndex != -1 && leftIndex != i) {
                        res.add(Arrays.asList(i, leftIndex));
                    }
                }
                if (j != 0 && palindrome(word, 0, j - 1)) {//如果[0...j-1]是回文，符合情况3，word是s2,回文部分是t1，下面看存不存在[j...len-1]的翻转
                    int rightIndex = index.getOrDefault(word.substring(j, len), -1);
                    if (rightIndex != -1 && rightIndex != i) {
                        res.add(Arrays.asList(rightIndex, i));
                    }
                }
            }
        }
        return res;
    }

    private boolean palindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
