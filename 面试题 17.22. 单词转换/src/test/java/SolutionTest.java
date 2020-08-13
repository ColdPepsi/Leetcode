/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * 类SolutionTest.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年08月07日 17:43:54
 */
public class SolutionTest {
    Solution2 solution2 = new Solution2();

    @Test
    public void test() {
        String[] arr = {"most","mist","miss","lost","fist","fish"};
        solution2.findLadders("lost", "miss", Arrays.asList(arr));
    }
}

    