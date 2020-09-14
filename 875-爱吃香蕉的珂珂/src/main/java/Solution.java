/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：暴力求解,会超时,在有序区间查找优先想二分查找
 *
 * @author wubiao21 2020年09月08日 10:59:07
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int right = (int) (1E9);
        int left = 1;//最终结果在[left,right]之间
        while (left < right) {
            int mid = left + (right - left) / 2;//取中点
            int time = 0;//计算如果每小时吃mid根 需要多少个小时吃完
            for (int pile : piles) {
                time += (pile - 1) / mid + 1;
            }
            if (time <= H) {//如果合格，说明最优结果在[left,mid]中
                right = mid;
            } else {//如果不合格，说明最优结果在（mid,right]中
                left = mid + 1;
            }
        }
        //退出循环时left==right
        return left;
    }
}