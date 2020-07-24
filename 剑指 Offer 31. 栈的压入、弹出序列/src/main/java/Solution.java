/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Stack;

/**
 * 类Solution.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年07月23日 17:21:07
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Stack<Integer> inStack = new Stack<>();
        int index1 = 0;
        for (int num : pushed) {
            inStack.push(num);//入栈
            while (!inStack.isEmpty() && inStack.peek() == popped[index1]) {
                inStack.pop();
                index1++;
            }
        }
        return inStack.isEmpty();
    }
}