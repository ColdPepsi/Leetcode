/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：本题没有比表述清楚，求连通图个数，每个连通图是1*n或者n*1的长条，且不能相交相邻，中间要有.来间隔
 *
 * @author wubiao21 2020年10月09日 11:11:27
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.' || i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X') {//当一个点是战舰，但是它左边或者上面是X说明它是战舰的中间部分，直接跳过
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}