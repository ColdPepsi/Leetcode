/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：顺时针打印矩阵
 *
 * @author wubiao21 2020年07月08日 11:31:12
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int count = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>(count);
        int top = 0;//上下左右四个边界
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {//上边界
                res.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);//右边界
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);//下边界
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}