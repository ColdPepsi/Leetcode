/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 *
 * @author wubiao21 2020年07月17日 18:52:09
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int totalXor = 0;
        for (int num : nums) {
            totalXor ^= num;
        }
        //n&(n-1) 去除 n 的位级表示中最低的那一位 1
        //n&(-n) 得到 n 的位级表示中最低的那一位 1
        int oneBit = totalXor & (-totalXor);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & oneBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}