/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：类似面试题16.10生存人数。求重叠区间数。O(n)解决
 *
 * @author wubiao21 2020年09月30日 16:14:21
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] up = new int[1001];//统计某站的上车人数
        int[] down = new int[1001];//统计某站的下车人数
        for (int[] trip : trips) {
            up[trip[1]] += trip[0];
            down[trip[2]] += trip[0];
        }
        for (int i = 1; i < 1001; i++) {//变成前缀和,表示从站0到目前站所有的上车人数或所有的下车人数
            up[i] += up[i - 1];
            down[i] += down[i - 1];
        }
        for (int i = 0; i < 1001; i++) {
            if (up[i] - down[i] > capacity) {//上车人数-下车人数，等于目前车上有多少人，人数超过座位就返回false
                return false;
            }
        }
        return true;
    }
}