/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 暴力解法
 *
 * @author wubiao21 2020年07月15日 15:58:00
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                int start = i;//当前结点可以作为起点
                int leftGas = 0;//当前剩下多少油
                int count = 1;//表示已访问当前结点
                while (count <= len) {
                    leftGas = leftGas + gas[start] - cost[start];//走到下一站剩下多少油
                    if (leftGas < 0) {//油量不够抵达第一站就终止，尝试下一个起点
                        break;
                    }
                    start = (start + 1) % len;
                    count++;
                }
                if (count > len) {//如果走完所有结点，则从start已经回到原点，输出start
                    return start;
                }
            }
        }
        return -1;//返回-1，没有找到结果
    }
}