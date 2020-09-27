/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.PriorityQueue;

/**
 * 类MedianFinder.java的实现描述：算法思想来自labuladong
 *
 * @author wubiao21 2020年09月17日 11:27:16
 */
public class MedianFinder {

    private final PriorityQueue<Integer> large;
    private final PriorityQueue<Integer> small;

    public MedianFinder() {
        //小顶堆，存放大元素
        large = new PriorityQueue<>();
        //大顶堆，存放小元素
        small = new PriorityQueue<>((a, b) -> b - a);
    }

    /**
     * 不仅要维护large和small堆里元素个数不超过1，还要维护，small的堆顶小于等于large的堆顶
     *
     * @param num
     */
    public void addNum(int num) {
        if (small.size() >= large.size()) {//应该加入到large里
            //如果num小于small堆顶，num会留在small堆中，下一步会把堆顶放入large堆
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }

    }

    public double findMedian() {
        //如果n是奇数，取元素较多的那个堆顶
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        } else {//如果n是偶数，两个堆元素个数一样，取对顶平均值
            return (large.peek() + small.peek()) / 2.0;
        }
    }
}