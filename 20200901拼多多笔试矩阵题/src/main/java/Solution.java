/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Scanner;

/**
 * 类Solution.java的实现描述：输入数字n，输出n阶矩阵，逆时针标号1~8，米字区域要全是0
 *
 * @author wubiao21 2020年09月02日 09:16:40
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int count = (n - 2) / 2;
        int left = 1;
        int right = n - 2;
        int row = 0;
        for (int i = count; i > 0; i--) {
            int k = left;
            for (int j = 0; j < i; j++) {
                matrix[row][k++] = 2;
            }
            k = right;
            for (int j = 0; j < i; j++) {
                matrix[row][k--] = 1;
            }
            row++;
            left++;
            right--;
        }
        left = 1;
        right = n - 2;
        row = n - 1;
        for (int i = count; i > 0; i--) {
            int k = left;
            for (int j = 0; j < i; j++) {
                matrix[row][k++] = 5;
            }
            k = right;
            for (int j = 0; j < i; j++) {
                matrix[row][k--] = 6;
            }
            row--;
            left++;
            right--;
        }
        left = 1;
        right = n - 2;
        row = 0;
        for (int i = count; i > 0; i--) {
            int k = left;
            for (int j = 0; j < i; j++) {
                matrix[k++][row] = 3;
            }
            k = right;
            for (int j = 0; j < i; j++) {
                matrix[k--][row] = 4;
            }
            row++;
            left++;
            right--;
        }
        left = 1;
        right = n - 2;
        row = n - 1;
        for (int i = count; i > 0; i--) {
            int k = left;
            for (int j = 0; j < i; j++) {
                matrix[k++][row] = 8;
            }
            k = right;
            for (int j = 0; j < i; j++) {
                matrix[k--][row] = 7;
            }
            row--;
            left++;
            right--;
        }
        StringBuilder ret = new StringBuilder(5 * n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret.append(matrix[i][j]).append(" ");
            }
            ret.replace(ret.length() - 1, ret.length(), "\r\n");
        }
        System.out.print(ret);
    }
}