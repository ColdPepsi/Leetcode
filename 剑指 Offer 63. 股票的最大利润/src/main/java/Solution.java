/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月29日 14:34:50
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;//记录以前的最小值
        int profit = 0;//记录最大利润
        for (int price : prices) {
            if (price < min) {
                min = price;//如果当前值小于最小值，就更新值
            } else {
                profit = Math.max(profit, price - min);//如果当前值大于最小值，就看看利润多大
            }
        }
        return profit;
    }
}