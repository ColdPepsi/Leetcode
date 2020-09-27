/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：奇偶性相同的两个数相减结果为偶数
 *
 * @author wubiao21 2020年09月14日 10:34:24
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        // status二进制最低位表示‘a’的出现次数奇偶性，如果出现次数为偶数，该为0，出现奇数次为1。status次低位表示‘e’的奇偶性，依次类推。
        // 初始时所有元音出现次数为0，status初始化为0
        int ans = 0, status = 0;
        int[] pos = new int[1 << 5];//pos[status]表示status最早出现的位置
        Arrays.fill(pos, -2);//初始化为-2，表示没有更新
        pos[0] = -1;//pos[0]初始化为-1，表示在下标-1，即什么字符也不选，出现了状态0，即元音一个也没出现。
        for (int i = 0; i < n; i++) {//遍历s，计算以字符[i]为序列末尾的最长字符串长度
            char c = s.charAt(i);
            switch (c) {//计算开头到现在的status
                case 'a':
                    status ^= 1;
                    break;
                case 'e':
                    status ^= (1 << 1);
                    break;
                case 'i':
                    status ^= (1 << 2);
                    break;
                case 'o':
                    status ^= (1 << 3);
                    break;
                case 'u':
                    status ^= (1 << 4);
                    break;
            }
            if (pos[status] == -2) {//status还没出现过，则更新pos[status]，在下标i第一次出现
                pos[status] = i;
            } else {//如果前面已经出现过相同的状态，即现在每个元音的奇偶和以前一样，保存最大长度
                ans = Math.max(ans, i - pos[status]);//区间为[pos[status]+1,i]
            }
        }
        return ans;
    }
}