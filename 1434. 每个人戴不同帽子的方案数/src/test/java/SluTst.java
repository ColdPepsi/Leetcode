/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubiao21 2020年08月03日 11:39:12
 */
public class SluTst {
    Solution solution = new Solution();

    @Test
    public void test() {
        int[][] arr = {{1, 2, 4, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 19, 20, 23, 24, 25},
                {2, 5, 16},
                {1, 4, 5, 6, 7, 8, 9, 12, 15, 16, 17, 19, 21, 22, 24, 25},
                {1, 3, 6, 8, 11, 12, 13, 16, 17, 19, 20, 22, 24, 25},
                {11, 12, 14, 16, 18, 24},
                {2, 3, 4, 5, 7, 8, 13, 14, 15, 17, 18, 21, 24},
                {1, 2, 6, 7, 10, 11, 13, 14, 16, 18, 19, 21, 23},
                {1, 3, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 20, 21, 22, 23, 24, 25},
                {2, 3, 4, 6, 7, 10, 12, 14, 15, 16, 17, 21, 22, 23, 24, 25}};
        List<List<Integer>> hats = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> temp = new ArrayList<>(40);
            for (int hat : ints) {
                temp.add(hat);
            }
            hats.add(temp);
        }
        long start = System.currentTimeMillis();
        System.out.println(solution.numberWays(hats));
        long end = System.currentTimeMillis();
        System.out.println("运行时间为：" + (end - start) + "毫秒");
    }
}

    