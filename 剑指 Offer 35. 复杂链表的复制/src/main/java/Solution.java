/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月23日 15:40:54
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {//先复制每个结点 衔接在自己的后面
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        for (temp = head; temp != null; temp = temp.next.next) {//下面开始处理random指针
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
        }
        Node newHead = new Node(0);//保存新的头
        for (Node currentNode = head, rear = newHead; currentNode != null; rear = rear.next, currentNode = currentNode.next) {//分开两个链表
            rear.next = currentNode.next;
            currentNode.next = currentNode.next.next;
        }
        return newHead.next;
    }
}