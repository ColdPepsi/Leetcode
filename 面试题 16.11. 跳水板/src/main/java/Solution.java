/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月08日 09:00:54
 */
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int sub = longer - shorter;
        if (sub == 0) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        res[0] = k * shorter;
        for (int i = 1; i <= k; i++) {
            //res[i] = (k - i) * shorter + i * longer;
            res[i] = res[i - 1] + sub;//长木板越多，则总长度越大，所以最后不用排序就是升序。
        }
        return res;
    }
}