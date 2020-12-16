/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：哈希表映射
 *
 * @author wubiao21 2020年12月16日 15:40:40
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");//存放分割后的字符串
        if (pattern.length() != strs.length) {
            return false;
        }
        String[] letterToString = new String[26];//字母到字符串的映射
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            int index = pattern.charAt(i) - 'a';
            if (letterToString[index] == null) {//为空则建立映射
                letterToString[index] = strs[i];
            } else {
                if (!letterToString[index].equals(strs[i])) {//不为空判断是否相等
                    return false;
                }
            }
        }
        //下面建立字符串到字母的映射，与上面同理
        Map<String, Character> stringToLetter = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            if (stringToLetter.containsKey(str)) {
                if (stringToLetter.get(str) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                stringToLetter.put(str, pattern.charAt(i));
            }
        }
        return true;
    }
}

    