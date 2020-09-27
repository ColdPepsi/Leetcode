/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：二分查找
 *
 * @author wubiao21 2020年09月17日 09:42:08
 */
public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int maxWeight = -1;
        int totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        //二分查找合适的重量，合适的重量所在区间[maxWeight,totalWeight]
        int left = maxWeight;
        int right = totalWeight;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canShip(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 验证负载能力为load情况下，day天能不能运完货物
     *
     * @param weights
     * @param load    船负载能力
     * @param day     天数
     * @return 能运完返回true
     */
    private boolean canShip(int[] weights, int load, int day) {
        int currentWeight = 0;//当天累加的重量
        for (int weight : weights) {
            currentWeight += weight;
            if (currentWeight > load) {//如果加上这个货物超重了，这个货物就明天运
                day--;//天数--；
                currentWeight = weight;//重新计数
            }
        }
        return day > 0;
    }
}