/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 类SluTst.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年09月01日 17:47:21
 */
public class SluTst {
    Solution2 solution=new Solution2();

    @Test
    public void test(){
        List<Node> child1=new ArrayList<>();
        child1.add(new Node(5));
        child1.add(new Node(6));
        Node head3=new Node(3,child1);
        List<Node> child2=new ArrayList<>();
        child2.add(head3);
        child2.add(new Node(2));
        child2.add(new Node(4));
        Node head=new Node(1,child2);
        solution.levelOrder(head);
    }
}

    