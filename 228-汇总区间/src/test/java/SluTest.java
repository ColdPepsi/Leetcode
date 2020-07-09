/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 *
 * @author wubiao21 2020年07月09日 20:06:54
 */
public class SluTest {

    Solution solution=new Solution();

    @Test
    public void test(){
        int[] arr={-2147483648,-2147483647,2147483647};
        solution.summaryRanges(arr);
    }
}

    