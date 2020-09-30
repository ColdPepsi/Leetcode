/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 类Solution.java的实现描述：我们可以将区间[0,N)看做一个数组，然后将blacklist中的元素移到数组的最末尾。思想类似380题
 *
 * @author wubiao21 2020年09月29日 14:51:55
 */
public class Solution {

    private final Random random;
    private final int count;//数组中有效的元素个数
    private final Map<Integer, Integer> map;//存放黑名单与有效元素的映射，相当于把黑名单的数，移动到数组的末尾


    public Solution(int N, int[] blacklist) {
        count = N - blacklist.length;
        random = new Random();
        map = new HashMap<>(blacklist.length);
        // 先将所有黑名单数字加入 map
        //value是多少都可以，目的仅仅是把键存进哈希表
        //方便快速判断数字是否在黑名单内
        for (int b : blacklist) {
            map.put(b, 666);
        }
        int last = N - 1;//最后一个数的索引
        for (int b : blacklist) {
            //如果b本身就在[count,N)这个区间则b无需建立映射，因为到时候只会访问[0，count）这个区间,后面的元素不会访问
            if (b >= count) {
                continue;
            }
            //跳过黑名单中的数字
            while (map.containsKey(last)) {
                last--;
            }
            // 将黑名单中的索引映射到合法数字
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        //[0，count）这个区间随机选取一个索引
        int index = random.nextInt(count);
        //索引在黑名单中，返回有效的数字
        if (map.containsKey(index)) {
            return map.get(index);
        }
        //没命中黑名单，直接返回结果
        return index;
    }
}