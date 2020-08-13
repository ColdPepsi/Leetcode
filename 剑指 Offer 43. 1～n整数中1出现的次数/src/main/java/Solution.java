/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 算法思想：
 * https://leetcode-cn.com/problems/number-of-digit-one/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-50/
 * 大佬都太强了…
 *
 * @author wubiao21 2020年08月11日 14:32:41
 */
public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long abc = n % k;
            long xyzd = n / k;
            long xyz = xyzd / 10;
            long d = xyzd % 10;
            count += xyz * k;
            if (d > 1) {
                count += k;
            } else if (d == 1) {
                count += abc + 1;
            }
        }
        return count;
    }
}