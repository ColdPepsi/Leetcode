/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 *
 * @author wubiao21 2020年07月15日 16:10:10
 */
public class SluTst {
    Solution solution=new Solution();

    @Test
    public void test(){
        int[] gas={1,2,3,4,5};
        int[] costs={3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, costs));
    }
}

    