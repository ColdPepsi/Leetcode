/**
 * @author WuBiao
 * @date 2020/5/15 21:29
 */
public class MyCircularQueue {

    private int front;//指向刚刚出队的元素
    private int rear;//指向刚刚入队的元素
    private final int size;//指示队列有多长
    private final int[] queue;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        size = k + 1;
        queue = new int[size];//多申请一个，循环队列会有一个空间的浪费
        front = 0;
        rear = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {//满的话不能插入
            return false;
        }
        rear = (rear + 1) % size;
        queue[rear] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {//队列是空的不能出队
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(front + 1) % size];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;//只要两者重合，队列就是空的
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % size == front;//尾指针不能追上头指针
    }
}