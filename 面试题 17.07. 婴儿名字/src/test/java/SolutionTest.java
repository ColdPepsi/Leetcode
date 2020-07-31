/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 * 类Solution.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年07月31日 10:12:35
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        String[] str1 = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] str2 = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        solution.trulyMostPopular(str1, str2);
    }
}

    