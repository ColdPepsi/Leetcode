/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution2.java的实现描述：如果B是A无法到达的第一个点，则A~B之间的任何结点都无法到达B，这个思想很重要
 *
 * @author wubiao21 2020年07月16日 09:52:29
 */
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;//一路上总共的剩余油量
        int currentTank = 0;//当前的剩余油量
        int start = 0;
        for (int i = 0; i < n; i++) {
            int sub = gas[i] - cost[i];
            totalTank += sub;
            currentTank += sub;
            if (currentTank < 0) {//说明无法到达下一站
                start = i + 1;//把下一站作为新的起点，因为如果B是A无法到达的第一个点，则A~B之间的任何结点都无法到达B
                currentTank = 0;//当前油箱置空
            }
        }
        return totalTank < 0 ? -1 : start;
    }
    /*
     *
     * for循环是从0~n-1 当计算完最后证明 start向后走走道起点0  下面用反证法证明 可以从0 走到 start 即 start可以行走一圈
     * 已知 totalTank>=0
     * 取 （0，start）中 k点  假设 start不能到达k
     *
     * 整段路的 totalTank 变成了3段   [0，k]+[k+1,start)+[start,n-1] >=0
     * [k+1,start)必定小于0，因为起点为start，currentTank < 0 的时候才重置的start 所以[0，k]+[start,n-1] >0
     * 因为假设 start不能到达k 所以[start,n-1] + [0，k] < 0 所以矛盾
     * start必定能走到k
     *
     */
}