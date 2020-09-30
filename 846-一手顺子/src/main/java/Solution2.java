/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution2.java的实现描述：其实也是暴力解
 *
 * @author wubiao21 2020年09月28日 09:51:35
 */
public class Solution2 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        int len = hand.length;
        boolean[] visited = new boolean[len];//记录hand中相同的下标元素有没有被访问
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int index = i;//从i开始往前找顺子
                for (int j = 1; j < W; j++) {
                    for (; index < len; index++) {
                        if (!visited[index] && hand[index] == hand[i] + j) {//找到一个连续的数之后退出循环，找下一个
                            visited[index] = true;
                            break;
                        }
                    }
                    if (index == len) {//如果越界了，说明没找到，直接退出
                        return false;
                    }
                }
            }
        }
        return true;
    }
}