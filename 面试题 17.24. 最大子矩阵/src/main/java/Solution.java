/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年09月03日 10:23:49
 */
public class Solution {
    /**
     * 动态规划，把二维矩阵压缩到一维矩阵然后每个一维矩阵求最大子数组和，就是二维矩阵的和，思想很好
     *
     * @param matrix
     * @return
     */
    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] colPrefixSum = new int[rows][cols];//列前缀和colPrefixSum[i][j]代表matrix[0][j]到matrix[i][j]的列前缀和
        calculatePrefixSum(matrix, colPrefixSum);
        int[] temp = new int[cols];//存放压缩的矩阵
        int[] ret = new int[4];//存放结果
        int max = Integer.MIN_VALUE;//最大矩阵和
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                getColPrefixSum(temp, colPrefixSum, i, j, cols);//压缩行i到行j的矩阵到temp
                //下面的过程就是求一维矩阵最大子数组和的过程
                int sum = 0;//保存当前最大的子数组和
                int left = 0;//存放最大子数组和区间的左端点
                for (int k = 0; k < cols; k++) {
                    if (sum > 0) {//当前的sum大于0，然后就加上temp[k]
                        sum += temp[k];
                    } else {//小于0，sum = temp[k];说明重新计算子数组和
                        sum = temp[k];
                        left = k;//更新区间左端点
                    }
                    if (sum > max) {//如果大于max，则更新结果
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

    /**
     * 把 行[rowTop, rowBottom]的数据压缩到temp矩阵中
     *
     * @param temp
     * @param colPrefixSum
     * @param rowTop
     * @param rowBottom
     * @param cols
     */
    private void getColPrefixSum(int[] temp, int[][] colPrefixSum, int rowTop, int rowBottom, int cols) {
        for (int i = 0; i < cols; i++) {
            temp[i] = rowTop == 0 ? colPrefixSum[rowBottom][i] : (colPrefixSum[rowBottom][i] - colPrefixSum[rowTop - 1][i]);
        }
    }

    /**
     * 初始化colPrefixSum，计算列前缀和，用于快速计算出压缩矩阵中的列和
     *
     * @param matrix
     * @param colPrefixSum
     */
    private void calculatePrefixSum(int[][] matrix, int[][] colPrefixSum) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.arraycopy(matrix[0], 0, colPrefixSum[0], 0, cols);//初始化第一行
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                colPrefixSum[i][j] = colPrefixSum[i - 1][j] + matrix[i][j];
            }
        }
    }
}