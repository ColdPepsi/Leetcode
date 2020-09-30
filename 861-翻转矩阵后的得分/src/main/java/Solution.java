/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年09月27日 11:50:25
 */
public class Solution {
    /**
     * 要想值最大，就要保证第一列全是1，如果第一列不是1，即使后面全是1，也没有第一列是1大，
     * 所以我们要翻转成第一列全是1
     * 再第一列全是1的基础上，统计后面每列1的个数，如果该列有col个1，那么该列翻转过后就有rows-col个1，取最大值
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int ans = 0;
        for (int j = 0; j < cols; j++) {
            int col = 0;//计算每列有几个0，统计0和统计1个数没区别，不是0就是1
            for (int[] ints : A) {
                //对于第一列来说，ints[0] ^ ints[0]==0，col必然等于0，对于后面的列来说，因为每行第一列都是1，所以col计算的就是每列0的个数
                col += ints[j] ^ ints[0];
            }
            //取最多有多少个1，乘以该列的权值
            ans += Math.max(col, rows - col) * (1 << (cols - 1 - j));
        }
        return ans;
    }
}

    