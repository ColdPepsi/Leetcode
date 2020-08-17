/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 站在宏观的角度，不是局限每个人的出生死亡时间，计算某年总的出生人数和总的死亡人数，然后相减
 *
 * @author wubiao21 2020年08月12日 17:46:50
 */
public class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] live = new int[102];
        int[] gone = new int[102];
        for (int i = 0; i < birth.length; i++) {
            live[birth[i] - 1900]++;//统计某年出生的总人数
            gone[death[i] - 1900]++;//统计某年死亡的总人数
        }
        //计算前缀和
        for (int i = 1; i < live.length; i++) {
            live[i] += live[i - 1];//live[i] 从1900年到1900+i年所有的累积出生的人数
            gone[i] += gone[i - 1];//gone[i] 从1900年到1900+i年所有的累积死亡的人数
        }
        int maxCount = -1;//保存最大的生存人数
        int res = 0;//保存年份
        for (int i = 1; i < live.length; i++) {
            int liveCount = live[i] - gone[i - 1];//1900+i年的存活人数，总出生人数-总死亡人数
            if (liveCount > maxCount) {//更新结果
                maxCount = liveCount;
                res = i;
            }
        }
        return 1900 + res;
    }
}