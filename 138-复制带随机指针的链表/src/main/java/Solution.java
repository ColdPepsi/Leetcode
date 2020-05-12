/**
 * @author WuBiao
 * @date 2020/5/7 21:36
 */
public class Solution {
    /**
     * @param head
     * @return Node
     * @description A->B->C变成A->A'->B->B'->C->C'，设置完random指针再分开链表
     * @author WuBiao
     * @date 2020/5/7 22:33
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copy(head);
        setRandom(head);
        return splitListNode(head);
    }

    /**
     * @param head
     * @return void
     * @description 把A->B->C变成A->A'->B->B'->C->C'
     * @author WuBiao
     * @date 2020/5/7 22:34
     */
    private void copy(Node head) {
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }
    }

    /**
     * @param head
     * @return void
     * @description 设置random指针
     * @author WuBiao
     * @date 2020/5/7 22:35
     */
    private void setRandom(Node head) {
        while (head != null && head.next != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    /**
     * @param head
     * @return Node
     * @description 分开成两个单链表
     * @author WuBiao
     * @date 2020/5/7 22:35
     */
    private Node splitListNode(Node head) {
        Node newHead = head.next;
        Node rear1 = head;
        Node rear2 = newHead;
        while (rear2 != null && rear2.next != null) {
            rear1.next = rear2.next;
            rear2.next = rear1.next.next;
            rear1 = rear1.next;
            rear2 = rear2.next;
        }
        rear1.next = null;
        return newHead;
    }
}