/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 * 类SluTst.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年09月10日 14:12:43
 */
public class SluTst {
    Solution solution=new Solution();

    @Test
    public void test(){
        int[] arr={1,0,1,0,1};
        System.out.println(solution.numSubarraysWithSum(arr, 2));
    }
}

    