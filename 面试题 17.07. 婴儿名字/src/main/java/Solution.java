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
 * @author wubiao21 2020年07月31日 09:40:24
 */
public class Solution {

    private String minName;//记录每个名字字典序最小的相似名名字
    private int count;//记录每个相似名字合并后的计数

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, List<String>> nameGraph = new HashMap<>(names.length);
        for (String synonym : synonyms) {//相似名字构建邻接表，相似的名字之间会组成一个无向图
            String[] strings = getNames(synonym);
            List<String> list = nameGraph.getOrDefault(strings[0], new ArrayList<>());
            list.add(strings[1]);
            nameGraph.put(strings[0], list);
            list = nameGraph.getOrDefault(strings[1], new ArrayList<>());
            list.add(strings[0]);
            nameGraph.put(strings[1], list);
        }
        Map<String, Integer> mapOfFrequency = new HashMap<>(names.length);
        for (String name : names) {
            String[] nameAndFrequency = getNameAndFrequency(name);
            mapOfFrequency.put(nameAndFrequency[0], Integer.parseInt(nameAndFrequency[1]));//更新每个名字的频率
            // synonyms数组可能不会包含所有的名字，需要把剩下的名字加进去
            nameGraph.putIfAbsent(nameAndFrequency[0], null);
        }

        Set<String> visited = new HashSet<>(mapOfFrequency.size());//保存某个结点有没有被访问
        List<String> res = new ArrayList<>(visited.size());//结果集
        for (String name : mapOfFrequency.keySet()) {
            if (!visited.contains(name)) {
                minName = name;//字典序最小的名字更新为当前的名字
                count = 0;//计数器置0
                dfs(name, nameGraph, visited, mapOfFrequency);
                res.add(minName + '(' + count + ')');//把结果加入结果集
            }
        }
        //下面是把数组转换成string数组
        String[] ret = new String[res.size()];
        int index = 0;
        for (String string : res) {
            ret[index++] = string;
        }
        return ret;
    }

    /**
     * 相似的名字之间会构成一个无向图，dfs遍历该无向图
     *
     * @param CurrentName    当前处理的名字
     * @param nameGraph      名字组成的邻接表
     * @param visited        标记某个名字有没有被访问
     * @param mapOfFrequency 记录名字出现的次数
     */
    private void dfs(String CurrentName, Map<String, List<String>> nameGraph,
                     Set<String> visited, Map<String, Integer> mapOfFrequency) {
        count += mapOfFrequency.getOrDefault(CurrentName, 0);//加上该名字的计数
        visited.add(CurrentName);//标记为已访问
        if (CurrentName.compareTo(minName) < 0) {//保存字典序最小的名字
            minName = CurrentName;
        }
        List<String> names = nameGraph.get(CurrentName);
        if (names != null) {//邻接表非空再进行dfs
            for (String name : names) {
                if (!visited.contains(name)) {
                    dfs(name, nameGraph, visited, mapOfFrequency);
                }
            }
        }
    }

    /**
     * 分割名字和频率的字符串，去掉括号
     *
     * @param str
     * @return
     */
    private String[] getNameAndFrequency(String str) {
        int leftBracketPos = str.lastIndexOf('(');//找到左括号
        return new String[]{str.substring(0, leftBracketPos), str.substring(leftBracketPos + 1, str.length() - 1)};
    }

    /**
     * 分割相似名字符串
     *
     * @param str
     * @return
     */
    private String[] getNames(String str) {
        int pos = str.indexOf(',');//找到逗号，然后分割
        return new String[]{str.substring(1, pos), str.substring(pos + 1, str.length() - 1)};
    }
}