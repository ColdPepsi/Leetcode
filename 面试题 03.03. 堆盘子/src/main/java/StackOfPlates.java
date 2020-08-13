/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wubiao21 2020年08月06日 21:24:17
 */
public class StackOfPlates {

    private final int cap;
    private final List<List<Integer>> volumes;

    public StackOfPlates(int cap) {
        this.cap = cap;
        volumes = new LinkedList<>();
    }

    public void push(int val) {
        if (cap == 0) {
            return;
        }
        int size = volumes.size();
        if (volumes.isEmpty() || volumes.get(size - 1).size() >= cap) {//如果没有栈或者链表最后一个栈已经超了cap，此时需要新建一个栈
            volumes.add(new ArrayList<>(cap));
            volumes.get(size).add(val);
        } else {
            volumes.get(size - 1).add(val);//否则直接加入最后一个栈
        }
    }

    public int pop() {
        return popAt(volumes.size() - 1);//直接调用popAt()
    }

    public int popAt(int index) {
        if (cap == 0 || volumes.isEmpty() || index >= volumes.size()) {
            return -1;
        }
        List<Integer> list = volumes.get(index);
        int res = list.remove(list.size() - 1);//栈顶出栈
        if (list.isEmpty()) {//为空则移除
            volumes.remove(index);
        }
        return res;
    }
}