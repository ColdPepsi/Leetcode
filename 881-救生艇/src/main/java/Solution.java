/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Arrays;

/**
 * 类Solution.java的实现描述：排序然后双指针
 *
 * @author wubiao21 2020年09月28日 17:34:54
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit) {//最胖的搭档一个最瘦的，看体重和，如果体重和小于limit，俩人一起走
                left++;
            }
            right--;//否则的话，最胖的自己走
            count++;//计数器加一
        }
        if (left == right) {//退出循环的时候，如果只剩下1个人，他就自己走
            count++;
        }
        return count;
    }
}