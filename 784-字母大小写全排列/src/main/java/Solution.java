/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：回溯，每个字符有两种可能，大写或者小写
 *
 * @author wubiao21 2020年09月27日 17:20:02
 */
public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<Integer> pos = new ArrayList<>(12);//保存字符的下标
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {//看看有几个字符，并把下标保存到pos中
            if (Character.isLetter(chars[i])) {
                pos.add(i);
            }
        }
        List<String> ret = new ArrayList<>((int) Math.pow(2, pos.size()));
        if (pos.size() == 0) {
            ret.add(S);
        } else {
            backTracking(0, ret, pos, chars);
        }
        return ret;
    }

    private void backTracking(int index, List<String> ret, List<Integer> pos, char[] chars) {
        if (index >= pos.size()) {
            ret.add(new String(chars));
            return;
        }
        char c = chars[pos.get(index)];
        //变成相反的字符然后回溯
        if (Character.isUpperCase(c)) {
            chars[pos.get(index)] = Character.toLowerCase(c);
        } else {
            chars[pos.get(index)] = Character.toUpperCase(c);
        }
        backTracking(index + 1, ret, pos, chars);
        //恢复成原来的字符，再回溯一遍
        chars[pos.get(index)] = c;
        backTracking(index + 1, ret, pos, chars);
    }
}