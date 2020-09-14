/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 递归的时候不要局限于递归的细节，站在宏观的角度想怎么利用递归的返回值
 *
 * @author wubiao21 2020年09月09日 10:36:35
 */
public class Solution {

    public int brokenCalc(int X, int Y) {
        if (Y <= X) {//y比x小，只能通过x减1来达到y
            return X - Y;
        }
        if (Y % 2 == 1) {//y是奇数，x可以通过brokenCalc(X, (Y + 1) / 2)次操作得到（Y+1）/2，然后（Y+1）/2通过乘2再减1两次操作得到y
            return 2 + brokenCalc(X, (Y + 1) / 2);
        } else {//y是偶数，x可以通过brokenCalc(X, Y / 2)次操作得到y/2，然后y/2再通过乘2一次操作得到y；
            return 1 + brokenCalc(X, Y / 2);
        }
    }
}