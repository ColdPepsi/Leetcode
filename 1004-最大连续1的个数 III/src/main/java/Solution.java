/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：我们可以理解为，滑动窗口内最多有K个0，求滑动窗口最大的长度
 *
 * @author wubiao21 2020年09月07日 13:59:23
 */
public class Solution {
    public int longestOnes(int[] A, int K) {
        int count = 0;//统计0的个数
        int left = 0;//滑动窗口区间左端点
        int right = 0;//滑动窗口区间右端点
        int res = 0;//最终结果
        //滑动窗口表示的区间为[left,right)，左闭右开
        while (right < A.length) {
            if (A[right++] == 0) {//窗口扩充一个元素，如果为0则count++；
                count++;
            }
            while (count > K) {//当窗口内0的个数超过k时候，开始收缩窗口
                if (A[left++] == 0) {//如果刚滑出窗口的元素是0，则count--;
                    count--;
                }
            }
            //此时count<=K,保存窗口的最大宽度
            res = Math.max(res, right - left);
        }
        return res;
    }
}

    