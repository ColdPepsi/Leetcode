import entity.ListNode;

/**
 * 类MyLinkedList.java的实现描述：自己设计链表，实现增删改查
 *
 * @author wubiao21 2020年07月06日 15:55:32
 */
public class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode(Integer.MIN_VALUE);
        tail = head;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (validIndex(size, index)) {
            ListNode res = head;
            for (int i = 0; i <= index; i++) {
                res = res.next;
            }
            return res.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {//调整尾指针
            tail = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (tail == head) {//此时链表为空
            head.next = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {//小于等于0都是头插
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode preNode = head;
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;//找到要插入结点的前一个结点
            }
            newNode.next = preNode.next;
            preNode.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (!validIndex(size, index)) {
            return;
        }
        ListNode preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;//找到前置结点
        }
        if (preNode.next.next == null) {//如果要删除的结点是最后一个结点
            tail = preNode;//更新尾指针
        }
        preNode.next = preNode.next.next;//删除结点
        size--;
    }

    /**
     * 返回索引是否合法
     *
     * @param size  当前链表size
     * @param index 索引值
     * @return 合法返回true
     */
    private boolean validIndex(int size, int index) {
        return index < size && index >= 0;
    }
}