/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @author wubiao21 2020年09月29日 14:13:46
 */
public class RandomizedSet {

    private final Random random;//用于生成随机数
    private final List<Integer> nums;//保存数
    private final Map<Integer, Integer> indexes;//保存某个数在数组中的索引

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        random = new Random();
        nums = new ArrayList<>();
        indexes = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }
        indexes.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexes.containsKey(val)) {
            return false;
        }
        int index = indexes.get(val);
        Integer lastEle = nums.get(nums.size() - 1);
        //把数组最后一个元素换到index处，然后把数组最后一个元素删除
        indexes.put(lastEle, index);
        nums.set(index, lastEle);
        nums.remove(nums.size() - 1);
        indexes.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}