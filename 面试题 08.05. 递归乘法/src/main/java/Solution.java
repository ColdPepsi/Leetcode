/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 *
 * @author wubiao21 2020年08月06日 21:04:14
 */
public class Solution {
    public int multiply(int A, int B) {//保证A小于等于B
        if (A > B) {
            return multiply(B, A);
        }
        if (A == 1) {
            return B;
        }
        return B + multiply(A - 1, B);
    }
}