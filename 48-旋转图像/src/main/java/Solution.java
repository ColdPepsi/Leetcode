/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：矩阵先转置，再反转每一行
 *
 * @author wubiao21 2020年08月27日 14:53:09
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //矩阵转置
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        //反转每行
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                swap(matrix, i, j, i, length - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int row, int col, int row2, int col2) {
        matrix[row][col] += matrix[row2][col2];
        matrix[row2][col2] = matrix[row][col] - matrix[row2][col2];
        matrix[row][col] -= matrix[row2][col2];
    }
}