/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * @author wubiao21 2020年07月17日 10:07:49
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);//排序
        int count = 0;//计数，当前第几篇论文
        int res = Integer.MIN_VALUE;//保存结果
        for (int i = citations.length - 1; i >= 0 && res < citations[i]; i--) {//倒着来,//有个剪枝条件，再往下越来越小，可以提前终止
            count++;
            res = Math.max(res, Math.min(citations[i], count));
        }
        return res;
    }
}