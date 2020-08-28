/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：从最外层开始旋转，由外到内，每层分别旋转
 *
 * @author wubiao21 2020年08月27日 15:32:56
 */
public class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int pos1 = 0;
        int pos2 = n - 1;
        while (pos1 < pos2) {
            int offset = 0;
            while (offset < pos2 - pos1) {
                /*左上坐标为（pos1,pos1+offset）
                右上坐标为（pos1+offset,pos2）
                右下坐标为（pos2,pos2-offset）
                左下坐标为（pos2-offset,pos1）*/
                int temp = matrix[pos1][pos1 + offset];
                matrix[pos1][pos1 + offset] = matrix[pos2 - offset][pos1];
                matrix[pos2 - offset][pos1] = matrix[pos2][pos2 - offset];
                matrix[pos2][pos2 - offset] = matrix[pos1 + offset][pos2];
                matrix[pos1 + offset][pos2] = temp;
                offset++;
            }
            pos1++;
            pos2--;
        }
    }
}