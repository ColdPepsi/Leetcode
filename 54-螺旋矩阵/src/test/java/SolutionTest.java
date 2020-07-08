/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

import java.util.List;

/**
 * @author wubiao21 2020年07月08日 13:44:29
 */
public class SolutionTest {
    Solution solutionTest = new Solution();

    @Test
    public void slutex() {
        int[][] res = {{1, 2, 3},{4,5,6},{7,8,9}};
        List<Integer> list = solutionTest.spiralOrder(res);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}

    