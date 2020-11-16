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
 * 类Solution.java的实现描述：字符排序后进行哈希
 *
 * @author wubiao21 2020年11月10日 16:28:41
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);//字符排序
            map.computeIfAbsent(new String(chars), string -> new ArrayList<>()).add(str);//排序后作为键，值就是列表
        }
        return new ArrayList<>(map.values());
    }
}

    