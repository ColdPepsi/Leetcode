/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：暴力解法
 *
 * @author wubiao21 2020年11月10日 17:50:11
 */
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int left = i;
            int currentHeight = heights[i];
            while (left > 0 && heights[left - 1] >= currentHeight) {
                left--;
            }
            int right = i;
            while (right < len - 1 && heights[right + 1] >= currentHeight) {
                right++;
            }
            res = Math.max(res, (right - left + 1) * currentHeight);
        }
        return res;
    }
}