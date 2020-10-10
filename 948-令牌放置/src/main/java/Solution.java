/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：贪心策略，能量和分互换，当我们用能量换分时，必然想用最少的能量换1分，用分换能量的时候，应该用1分换取最多的能量
 *
 * @author wubiao21 2020年10月09日 09:38:20
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int points = 0;
        int ans = 0;
        while (left <= right && (P >= tokens[left] || points > 0)) {
            while (left <= right && P >= tokens[left]) {//如果可以换分，就一直换分
                P -= tokens[left++];
                points++;
            }
            ans = Math.max(ans, points);//保存最大分数
            if (left <= right && points > 0) {//不能换分的话，就牺牲1分换能量
                points--;
                P += tokens[right--];
            }
        }
        return ans;
    }
}