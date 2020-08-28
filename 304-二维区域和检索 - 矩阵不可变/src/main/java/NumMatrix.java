/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类NumMatrix.java的实现描述：模仿一维数组前缀和，只不过这个变成了二维
 *
 * @author wubiao21 2020年08月28日 11:26:33
 */
public class NumMatrix {

    private final int[][] preSum;


    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            preSum = new int[0][0];
            return;
        }
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        preSum = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            preSum[i][0] = matrix[i][0];
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                preSum[i][j] = preSum[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += getRowSum(i, col1, col2);
        }
        return sum;
    }

    /**
     * 获取matrix[row][left...right]的和
     *
     * @param row   行号
     * @param left  区间左端点
     * @param right 区间右端点
     * @return
     */
    private int getRowSum(int row, int left, int right) {
        return left == 0 ? preSum[row][right] : preSum[row][right] - preSum[row][left - 1];
    }
}