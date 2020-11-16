/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：把偶数放在A[0]、A[2]、A[4]...把奇数放在A[1]、A[3]、A[5]...
 *
 * @author wubiao21 2020年11月12日 09:59:07
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0, j = 1; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] -= a[j];
    }
}