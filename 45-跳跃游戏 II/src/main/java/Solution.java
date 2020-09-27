/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：贪心，每次在可抵达的范围内选择跳的更远的位置
 *
 * @author wubiao21 2020年09月15日 20:27:00
 */
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;//当前能跳跃的边界
        int maxPos = 0;//保存在可抵达的范围内选择跳的更远的位置
        int step = 0;//最后结果
        len--;//不用遍历最后一个，在到达最后一个元素之前，最远边界一定大于等于最后一个位置，不然不能抵达最后一个位置
        for (int i = 0; i < len; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);//记录最远的位置
            if (i == end) {//抵达当前范围的边界
                end = maxPos;
                step++;//计数器加1；
            }
        }
        return step;
    }
}