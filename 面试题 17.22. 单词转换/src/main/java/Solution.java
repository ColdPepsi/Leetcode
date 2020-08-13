/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 找中间状态
 *
 * @author wubiao21 2020年08月07日 15:39:31
 */
public class Solution {

    /**
     * 封装一个内部类，因为最后要输出转换过程，所以要记录转换的路径
     */
    private static class Node {
        String val;//保存单词值
        Node parent;//记录父亲，也就是由那个单词转换来的

        Node(String val) {
            this.val = val;
            parent = null;
        }

        Node(String val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        int wordLen = beginWord.length();
        // 键是中间状态，值是所有具有相同中间状态的单词的列表
        Map<String, List<String>> midStatusMap = new HashMap<>(size * wordLen);
        Set<String> hasVisited = new HashSet<>(size);//记录某个单词有没有被访问，访问过加入到set中
        boolean inList = false;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                inList = true;//记录endWord有没有在wordList中
            }
            for (int i = 0; i < word.length(); i++) {
                String midStatus = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);//中间状态
                List<String> list = midStatusMap.getOrDefault(midStatus, new ArrayList<>());
                list.add(word);//加入列表
                midStatusMap.put(midStatus, list);
            }
        }
        List<String> ret = new ArrayList<>(size);//最后的结果集
        if (!inList) {//如果endWord没有在wordList中，直接返回false
            return ret;
        }
        Queue<String> queue = new LinkedList<>();//BFS的队列
        queue.offer(beginWord);
        boolean findEndWord = false;
        Map<String, Node> map = new HashMap<>(size);//记录字符串和他生成的结点
        map.put(beginWord, new Node(beginWord));
        while (!queue.isEmpty()) {
            String head = queue.poll();
            Node parent = map.get(head);
            for (int i = 0; i < wordLen; i++) {
                String midStatus = head.substring(0, i) + "*" + head.substring(i + 1, wordLen);
                List<String> strings = midStatusMap.get(midStatus);
                if (strings != null) {
                    for (String string : strings) {
                        if (hasVisited.contains(string)) {
                            continue;
                        }
                        hasVisited.add(string);
                        queue.offer(string);
                        map.put(string, new Node(string, parent));//生成结点并设置父亲
                        if (string.equals(endWord)) {
                            findEndWord = true;//标记找到结果，主要用来跳出外层循环
                            break;
                        }
                    }
                }
            }
            if (findEndWord) {//找到结果，提前终止
                break;
            }
        }
        //下面组装结果
        Node node = map.get(endWord);
        while (node != null) {
            ret.add(node.val);
            node = node.parent;
        }
        Collections.reverse(ret);
        return ret;
    }
}