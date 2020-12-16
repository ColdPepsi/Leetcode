/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：算法思想来自：https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
 *
 * @author wubiao21 2020年12月16日 15:25:07
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>((int) Math.pow(2, n));
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {//逆序遍历
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}

    