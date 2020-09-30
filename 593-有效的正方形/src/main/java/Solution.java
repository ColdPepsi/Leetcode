/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：按横坐标排序
 *
 * @author wubiao21 2020年09月29日 13:41:32
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Arrays.sort(p, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        //四条边分别为p[0], p[1]；p[0], p[2]；p[3], p[1]；p[3], p[2]；
        //对角线为p[0], p[3]；p[1], p[2]；
        return equal(distance(p[0], p[3]), distance(p[1], p[2])) &&
                equal(distance(p[0], p[1]), distance(p[0], p[2]), distance(p[3], p[1]), distance(p[3], p[2]));
    }

    private boolean equal(int a, int b, int c, int d) {
        return a != 0 && a == b && b == c && c == d;
    }

    private boolean equal(int a, int b) {
        return a != 0 && a == b;
    }

    /**
     * 返回两点距离的平方和
     *
     * @param p1
     * @param p2
     * @return
     */
    private int distance(int[] p1, int[] p2) {
        int a = p1[1] - p2[1];
        int b = p1[0] - p2[0];
        return a * a + b * b;
    }
}