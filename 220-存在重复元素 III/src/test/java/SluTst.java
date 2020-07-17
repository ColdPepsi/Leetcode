/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 *
 * @author wubiao21 2020年07月16日 20:02:11
 */
public class SluTst {
    Solution2 solution=new Solution2();

    @Test
    public void test(){
        int[] arr={1,5,9,1,5,9};
        System.out.println(solution.containsNearbyAlmostDuplicate(arr, 2, 3));
    }
}

    