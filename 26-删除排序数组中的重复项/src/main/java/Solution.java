/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月06日 11:54:39
 */
public class Solution {
    /**
     * 双指针解法
     *
     * @param nums 含有重复数的数组
     * @return 新数组长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;//小于2个数不会出现重复节点
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];//不相等，则把nums[j]复制到前面
            }
            //如果相等的话，j++;会跳过前面的重复项，找到不相等的数
        }
        return i+1;
    }
}