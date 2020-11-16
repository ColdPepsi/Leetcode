/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：随机选择算法，和快排写法一样，但是这样会抛弃另一半，这样时间复杂度是O(n)
 *
 * @author wubiao21 2020年11月09日 13:59:52
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        getK(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void getK(int[][] points, int left, int right, int k) {
        if (left == right) {
            return;
        }
        int position = partition(points, left, right);
        int m = position - left + 1;
        if (k > m) {
            getK(points, position + 1, right, k - m);
        } else if (k < m) {
            getK(points, left, position - 1, k);
        }
    }

    private int partition(int[][] points, int left, int right) {
        int[] temp = points[left];
        int distant = temp[0] * temp[0] + temp[1] * temp[1];
        while (left < right) {
            while (left < right && points[right][0] * points[right][0] + points[right][1] * points[right][1] > distant) {
                right--;
            }
            points[left] = points[right];
            while (left < right && points[left][0] * points[left][0] + points[left][1] * points[left][1] <= distant) {
                left++;
            }
            points[right] = points[left];
        }
        points[left] = temp;
        return left;
    }
}