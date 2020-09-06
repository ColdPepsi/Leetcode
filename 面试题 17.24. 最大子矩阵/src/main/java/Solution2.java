/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：优化掉colPrefixSum
 *
 * @author wubiao21 2020年09月03日 13:52:34
 */
public class Solution2 {
    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] ret = new int[4];//存放结果
        int max = Integer.MIN_VALUE;//最大矩阵和
        for (int i = 0; i < rows; i++) {
            int[] temp = new int[cols];
            for (int j = i; j < rows; j++) {
                int sum = 0;
                int left = 0;
                for (int k = 0; k < cols; k++) {
                    temp[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += temp[k];
                    } else {
                        sum = temp[k];
                        left = k;
                    }
                    if (sum > max) {
                        max = sum;
                        ret[0] = i;
                        ret[1] = left;
                        ret[2] = j;
                        ret[3] = k;
                    }
                }
            }
        }
        return ret;
    }
}