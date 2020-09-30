/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution2.java的实现描述：同solution一样，只不过省掉了pos列表
 *
 * @author wubiao21 2020年09月27日 17:53:06
 */
public class Solution2 {
    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                count++;
            }
        }
        List<String> res = new ArrayList<>((int) Math.pow(2, count));
        if (count == 0) {
            res.add(S);
        } else {
            backTracking(0, res, chars);
        }
        return res;
    }

    private void backTracking(int index, List<String> res, char[] chars) {
        if (index >= chars.length) {
            res.add(new String(chars));
            return;
        }
        char c = chars[index];
        if (Character.isLetter(c)) {
            chars[index] ^= 32;//字符异或32可以起到大小写转换的作用
            backTracking(index + 1, res, chars);
            chars[index] = c;
        }
        backTracking(index + 1, res, chars);
    }
}