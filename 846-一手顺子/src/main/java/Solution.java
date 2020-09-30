/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Map;
import java.util.TreeMap;

/**
 * 类Solution.java的实现描述：暴力求解
 *
 * @author wubiao21 2020年09月28日 09:25:37
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int num : hand) {//统计每个牌出现的次数
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        while (!count.isEmpty()) {
            Map.Entry<Integer, Integer> entry = count.firstEntry();
            int first = entry.getKey();
            int times = entry.getValue();//顺子的第一张牌出现多少次
            for (int card = first; card < first + W; card++) {//每次从treeMap中抽取w个顺子
                int time = count.getOrDefault(card, 0);
                if (time < times) {
                    return false;
                } else if (time > times) {//每次减去第一张牌的次数
                    count.put(card, time - times);
                } else {
                    count.remove(card);//card用光了，就移出map
                }
            }
        }
        //顺利抽出所有牌表示成功
        return true;
    }
}

    