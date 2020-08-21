/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：动态规划2
 *
 * @author wubiao21 2020年08月20日 13:42:12
 */
public class Solution2 {
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;//记录最大数
        int min = Integer.MAX_VALUE;//记录最小数
        for (int integer : arr) {
            if (integer > max) {
                max = integer;
            }
            if (integer < min) {
                min = integer;
            }
        }
        int shift = Math.abs(difference);//表示偏移量，因为会出现负值，所以下标都统一偏移shift
        if (min < 0) {
            shift += -min;
        }
        int[] map = new int[max - min + 2 * Math.abs(difference) + 2];//数组省这么点空间意义不大，直接申请2万个也行
        int res = 0;
        for (int integer : arr) {
            int times = map[integer - difference + shift] + 1;
            map[integer + shift] = times;
            res = Math.max(res, times);
        }
        return res;
    }
}
/*
map[i]表示以i结尾的最长定差子序列，
map[i]=map[i-difference]+1
*/
