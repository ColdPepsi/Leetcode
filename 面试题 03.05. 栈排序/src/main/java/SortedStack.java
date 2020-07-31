/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Stack;

/**
 * @author wubiao21 2020年07月30日 16:22:29
 */
public class SortedStack {

    private final Stack<Integer> integerStack;//主栈,从底到顶递减
    private final Stack<Integer> auxStack;//辅助栈，保持主栈栈顶始终大于等于辅助栈顶，从底到顶递增

    public SortedStack() {
        integerStack = new Stack<>();
        auxStack = new Stack<>();
    }

    /**
     * 暴力解法，入栈的时候先把所有小于val的值弹出，最后再入栈
     *
     * @param val
     */
    public void push(int val) {
        if (integerStack.isEmpty()) {
            integerStack.push(val);//主栈空，则直接推入主栈
        } else if (integerStack.peek() < val) {//主栈顶小于val,则主栈一直出栈，直到主栈顶元素大于等于val
            while (!integerStack.isEmpty() && integerStack.peek() < val) {
                auxStack.push(integerStack.pop());
            }
            integerStack.push(val);
        } else if (auxStack.isEmpty() || auxStack.peek() <= val) {
            auxStack.push(val);//如果辅助栈为空，或者辅助栈顶小于等于val，则直接入辅助栈
        } else {
            while (!auxStack.isEmpty() && auxStack.peek() > val) {
                integerStack.push(auxStack.pop());//如果辅助栈顶大于val，则辅助栈一直出栈到主栈，直到辅助栈顶小于等于val
            }
            auxStack.push(val);
        }
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        while (!auxStack.isEmpty()) {//辅助站非空，则辅助栈全推到主栈
            integerStack.push(auxStack.pop());
        }
        integerStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return auxStack.isEmpty() ? integerStack.peek() : auxStack.get(0);//辅助站空了,直接返回主栈顶。否则，返回辅助栈底
    }

    public boolean isEmpty() {
        return integerStack.isEmpty() && auxStack.isEmpty();
    }
}