/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 类Solution.java的实现描述：127题，中间状态是亮点
 *
 * @author wubiao21 2020年07月06日 10:38:44
 */
public class Solution {
    /**
     * 找一个中间状态，然后BFS
     *
     * @param beginWord 开始词
     * @param endWord   目标词
     * @param wordList  单词列表
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> map = new HashMap<>(wordList.size());//键是中间状态，值保存所有中间状态相同的单词列表
        wordList.forEach(word -> {//wordList中每个单词都加入到map中
            for (int i = 0; i < len; i++) {
                String midStatus = word.substring(0, i) + "*" + word.substring(i + 1, len);//把单词的第i位换成* 作为中间状态
                List<String> stringList = map.getOrDefault(midStatus, new ArrayList<>());
                stringList.add(word);//把单词放到对应的中间状态的列表中
                map.put(midStatus, stringList);
            }
        });
        Set<String> hasVisted = new HashSet<>(wordList.size());//记录某个单词有没有访问,访问过就加入集合
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);//头结点入队，下面开始BFS
        hasVisted.add(beginWord);
        int step = 0;//记录层数
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {//一层一层来
                String head = queue.poll();//队首出队
                for (int j = 0; j < len; j++) {
                    String midStatus = head.substring(0, j) + "*" + head.substring(j + 1, len);//把单词的第j位换成* 作为中间状态
                    for (String word : map.getOrDefault(midStatus, new ArrayList<>())) {
                        if (word.equals(endWord)) {
                            return step + 1;//碰到终点值，返回结果
                        }
                        if (!hasVisted.contains(word)) {//如果该点没访问过
                            hasVisted.add(word);
                            queue.add(word);//入队
                        }
                    }
                }
            }
        }
        return 0;
    }
}