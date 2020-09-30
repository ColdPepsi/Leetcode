/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.LinkedList;

/**
 * @author wubiao21 2020年09月27日 11:44:13
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        boolean[] inStack = new boolean[26];//记录某个字符有没有出现在栈中
        int[] lastCurr = new int[26];//统计每个字符最后出现的位置
        for (int i = 0; i < chars.length; i++) {
            lastCurr[chars[i] - 'a'] = i;//初始化lastCurr数组
        }
        LinkedList<Character> stack = new LinkedList<>();//linkedlist作为栈来使用要快一点
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (inStack[aChar - 'a']) {//已经在栈中就跳过
                continue;
            }
            //因为要保证字典序最小，所以如果当前字符小于栈顶，并且栈顶元素后面还会出现，栈顶元素就出栈
            while (!stack.isEmpty() && aChar < stack.peekLast() && lastCurr[stack.peekLast() - 'a'] > i) {
                inStack[stack.pollLast() - 'a'] = false;
            }
            stack.offerLast(aChar);//当前元素入栈
            inStack[aChar - 'a'] = true;
        }
        StringBuilder ret = new StringBuilder(stack.size());//把栈中的元素加入到结果集中
        for (Character c : stack) {
            ret.append(c);
        }
        return ret.toString();
    }
}

    