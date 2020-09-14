/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.LinkedList;

/**
 * 算法思想来自官方题解：https://leetcode-cn.com/problems/online-stock-span/solution/gu-piao-jie-ge-kua-du-by-leetcode/
 * LinkedList比Stack速度快点
 *
 * @author wubiao21 2020年09月09日 14:17:47
 */
public class StockSpanner {

    private final LinkedList<Integer> prices;//保存price
    private final LinkedList<Integer> days;//保存price所对应的最近的一个大于price价格的日子

    public StockSpanner() {
        prices = new LinkedList<>();
        days = new LinkedList<>();
    }

    public int next(int price) {
        int day = 1;
        while (!prices.isEmpty() && prices.getLast() <= price) {//如果A[i]<=A[j],i<j,那么在第j天之后，第i天不会是任何一天的答案，所以出栈丢弃
            prices.pollLast();
            day += days.pollLast();
        }
        prices.offerLast(price);
        days.offerLast(day);
        return day;
    }
}