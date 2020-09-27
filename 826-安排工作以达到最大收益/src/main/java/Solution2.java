/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：排序时间复杂度过大，不用排序，直接遍历
 *
 * @author wubiao21 2020年09月16日 17:39:25
 */
public class Solution2 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxSkill = -1;//保存
        for (int skill : worker) {
            maxSkill = Math.max(skill, maxSkill);
        }
        int[] maxProfit = new int[maxSkill + 1];//maxProfit[i]表示难度为i的工作最大收益
        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= maxSkill) {//difficulty[i] > maxSkill时直接跳过，没人能完成
                maxProfit[difficulty[i]] = Math.max(maxProfit[difficulty[i]], profit[i]);//保存此项难度的最大收益
            }
        }
        int currentMaxProfit = -1;
        //难度和利润没关系，所以难度小可能利润大，maxProfit[i]更新难度小于i的工作最大收益
        for (int i = 0; i <= maxSkill; i++) {
            currentMaxProfit = Math.max(currentMaxProfit, maxProfit[i]);
            maxProfit[i] = currentMaxProfit;
        }
        int total = 0;
        for (int skill : worker) {
            total += maxProfit[skill];
        }
        return total;
    }
}

    