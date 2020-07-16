/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */


import java.util.LinkedList;
import java.util.List;

/**
 * 类Solution3.java的实现描述：迭代解法
 *
 * @author wubiao21 2020年07月15日 14:12:00
 */
public class Solution3 {
    public String getPermutation(int n, int k) {
        k--;//因为k除以一个数，是可以取到0的，所以我们从索引0开始
        List<Character> characterList = new LinkedList<>();
        char[] res = new char[n];//保存结果集
        for (int i = 1; i <= n; i++) {
            characterList.add((char) (i + '0'));
        }
        for (int i = 0; i < n; i++) {//i表示当前该处理的下标
            int count = factorial(n - 1 - i);
            int index = k / count;//看看在下标i上应该取哪个数
            res[i] = characterList.remove(index);//把它加入到结果集中，并从可选择的集合中删除
            k %= count;//k取余数
        }
        return new String(res);
    }

    /**
     * @param n 参数n
     * @return 返回n的阶乘
     */
    private int factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
    }
}