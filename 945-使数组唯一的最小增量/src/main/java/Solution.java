/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：此题算法思想来自官方题解
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/shi-shu-zu-wei-yi-de-zui-xiao-zeng-liang-by-leet-2/
 * 当我们找到一个没有出现过的数的时候，将之前某个重复出现的数增加成这个没有出现过的数。
 *
 * @author wubiao21 2020年09月07日 20:28:34
 */
public class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int i : A) {//统计每个字符出现多少次
            count[i]++;
        }
        int ans = 0;//记录操作次数
        int memo = 0;//记录有几个数字需要增加
        for (int i = 0; i < 80000; i++) {
            if (count[i] > 1) {//数字i出现了重复
                ans -= i * (count[i] - 1);//此处用了个优化，建议看官方题解
                memo += count[i] - 1;
            } else if (count[i] == 0 && memo > 0) {//出现没有出现过的数字，选前面需要处理的数字增加到i
                ans += i;
                memo--;//需要处理的数减1
            }
        }
        return ans;
    }
}

    