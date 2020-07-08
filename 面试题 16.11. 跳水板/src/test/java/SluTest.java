/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 * @author wubiao21 2020年07月08日 09:51:51
 */
public class SluTest {
    Solution2 solution = new Solution2();

    @Test
    public void test() {
        int[] ints = solution.divingBoard(1, 2, 3);
        for (Integer integer : ints) {
            System.out.println(integer);
        }
    }
}

    