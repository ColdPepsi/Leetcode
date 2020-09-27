/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年09月17日 13:39:17
 */
public class Solution {
    /**
     * 递归
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        } else if (num == 1) {
            return true;
        }
        if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else {
            return false;
        }
    }

    /**
     * 迭代，一直重复除2，3，5
     *
     * @param num
     * @return
     */
    public boolean isUgly2(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}