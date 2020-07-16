/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


/**
 * @author wubiao21 2020年07月15日 15:36:52
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}