/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：水题打卡题
 *
 * @author wubiao21 2020年08月28日 09:58:21
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        char[] chars = moves.toCharArray();
        int posX = 0;
        int posY = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case 'L':
                    posX--;
                    break;
                case 'R':
                    posX++;
                    break;
                case 'U':
                    posY++;
                    break;
                case 'D':
                    posY--;
                    break;
            }
        }
        return posX == 0 && posY == 0;
    }
}