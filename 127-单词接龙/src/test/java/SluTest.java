/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * 类SluTest.java的实现描述：测试类
 *
 * @author wubiao21 2020年07月06日 11:09:19
 */
public class SluTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }
}

    