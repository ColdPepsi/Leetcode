/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：同一副对角线上的元素横纵坐标和相同
 *
 * @author wubiao21 2020年10月09日 10:24:31
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        List<Integer>[] ans = new List[rows + cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = i + j;
                if (ans[temp] == null) {
                    ans[temp] = new ArrayList<>();
                }
                ans[temp].add(matrix[i][j]);
            }
        }
        boolean reverse = true;
        int index = 0;
        for (List<Integer> list : ans) {
            if (list != null) {
                if (reverse) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        res[index++] = list.get(i);
                    }
                } else {
                    for (Integer num : list) {
                        res[index++] = num;
                    }
                }
                reverse = !reverse;
            }
        }
        return res;
    }
}