/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 出现3次的数，每个二进制位都是3的倍数
 *
 * @author wubiao21 2020年07月23日 16:46:21
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];//计算所有的二进制位数
        for (int num : nums) {
            for (int i = 0; i < count.length && num != 0; i++) {
                count[i] += num & 1;//取num最低一位
                num >>>= 1;//无符号右移
            }
        }
        int res = 0;
        for (int i = 0, power = 1; i < count.length; i++, power *= 2) {//power是权值
            res += count[i] % 3 * power;
        }
        return res;
    }
}