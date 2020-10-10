/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 类Solution.java的实现描述：1 ≤ a[i] ≤ n这个条件要好好利用，正好数组下标范围。
 * 下标索引
 *
 * @author wubiao21 2020年10月10日 11:17:53
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>(32);
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {//说明次数已经访问过一次，改成了负数，所以数组中已经存在了nums[i]
                ret.add(index + 1);
            }
            nums[index] *= -1;//换成相反数，表示该索引已经范围过
        }
        return ret;
    }
}