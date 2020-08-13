/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类Solution2.java的实现描述：DFS实现
 *
 * @author wubiao21 2020年08月07日 16:58:27
 */
public class Solution2 {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        int wordLen = beginWord.length();
        // 键是中间状态，值是所有具有相同中间状态的单词的列表
        Map<String, List<String>> midStatusMap = new HashMap<>(size * wordLen);
        Set<String> hasVisited = new HashSet<>(size);//记录某个单词有没有被访问，访问过加入到set中
        boolean endWordInList = false;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                endWordInList = true;//记录endWord有没有在wordList中
            }
            if (word.equals(beginWord)) {
                continue;//不要把beginWord放入map中
            }
            for (int i = 0; i < word.length(); i++) {
                String midStatus = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);//中间状态
                List<String> list = midStatusMap.getOrDefault(midStatus, new ArrayList<>());
                list.add(word);//加入列表
                midStatusMap.put(midStatus, list);
            }
        }
        List<String> ret = new ArrayList<>(size);//最后的结果集
        if (!endWordInList) {
            return ret;
        }
        if (dfs(beginWord, endWord, ret, midStatusMap, hasVisited)) {
            ret.add(0, beginWord);
            return ret;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String beginWord, String endWord, List<String> ret, Map<String, List<String>> midStatusMap, Set<String> hasVisited) {
        if (endWord.equals(beginWord)) {
            return true;
        }
        for (int i = 0; i < beginWord.length(); i++) {
            String midStatus = beginWord.substring(0, i) + "*" + beginWord.substring(i + 1);//中间状态
            List<String> strings = midStatusMap.get(midStatus);
            if (strings != null) {
                for (String string : strings) {
                    if (hasVisited.contains(string)) {
                        continue;
                    }
                    ret.add(string);
                    hasVisited.add(string);
                    if (dfs(string, endWord, ret, midStatusMap, hasVisited)) {
                        return true;
                    }
                    /*hasVisited.remove(string);*///这是重点！！！ 走到这一步，说明string已经走不通了 ，不用标记为未访问
                    ret.remove(ret.size() - 1);
                }
            }
        }
        return false;
    }
}