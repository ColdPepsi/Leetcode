/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

/**
 * 类SluTst.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年08月20日 11:37:24
 */
public class SluTst {

    Solution solution=new Solution();
    int[] arr={1,2,3,4,5};
    @Test
    public void test(){
        assert (solution.longestSubsequence(arr,1)==5);
        String string="小名";
        System.out.println(string.length());
    }
}

    