/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 需求，根据商户ID，返回应该访问的接口，灰度发布
 *
 * @author wubiao21 2020年07月16日 18:10:01
 */
public class Solution {

    private final SortedMap<Integer, String> map;//结点到函数的映射

    private Solution() {
        map = new TreeMap<>();
        //假如hash算法hash区间为[0,99]
        //因为我们要 28分 所以取 0和 20， 因为是顺时针寻找，所以旧接口会覆盖(20,99]区间，80%
        // 20和 99 可以随着hash区间 还有接口数 百分比来计算
        map.put(20, "新接口名");
        map.put(99, "旧接口名");
    }

    /**
     * 根据商户ID，返回应该访问的接口，应用于灰度发布
     *
     * @param CustomerNum 商户号
     * @return 访问的接口名
     */
    public String getInterfaceName(int CustomerNum) {
        int hashCode = getHashCode(CustomerNum);//hash算法会返回hash区间内的数
        //下面根据hash值寻找顺时针第一个接口
        SortedMap<Integer, String> tailMap = this.map.tailMap(hashCode);//treeMap是有序的，返回根据hash值获得的尾map，该map的第一个键值对就是顺时针找到的第一个
        // 如果tail为空，则返回map的第一个节点即可，此解法不要求hash区间是环
        return tailMap.isEmpty() ? map.get(map.firstKey()) : map.get(tailMap.firstKey());
    }


    /**
     * 根据商户号返回hash码
     *
     * @param CustomerNum 商户号
     * @return
     */
    private int getHashCode(int CustomerNum) {
        return CustomerNum;
    }

    /**
     * 测试
     *
     * @param args
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getInterfaceName(10));
        System.out.println(solution.getInterfaceName(70));
    }
}

    