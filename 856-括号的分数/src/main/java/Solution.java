/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：分治的思想
 *
 * @author wubiao21 2020年09月28日 17:52:47
 */
public class Solution {
    public int scoreOfParentheses(String S) {
        //如果s长度小于2，或者s只有两个元素但是不是“（）”就返回0
        if (S.length() < 2 || (S.length() == 2 && (S.charAt(0) != '(' || S.charAt(1) != ')'))) {
            return 0;
        }
        //如果s是“（）”就返回1
        if (S.length() == 2 && S.charAt(0) == '(' && S.charAt(1) == ')') {
            return 1;
        }
        int flag = 0;
        int index = 0;
        //找到与第一个左括号“（”匹配的右括号，下标用index保存，这里没用栈，用flag来模拟出栈入栈
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag == 0) {
                index = i;
                break;
            }
        }
        if (index == S.length() - 1) {//如果S为“（A）”型
            return 2 * scoreOfParentheses(S.substring(1, index));
        } else {//如果S为“A+B”型
            return scoreOfParentheses(S.substring(0, index + 1)) + scoreOfParentheses(S.substring(index + 1));
        }
    }
}