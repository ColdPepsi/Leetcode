import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/3/9 19:38
 */
public class MyStack {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /**
     * @param x
     * @return void
     * @description 栈为FILO，所以队列入队时候在队尾，所以每次入队都需要前面的元素出队，再分别入队，保证刚入队的元素在队首
     * @author WuBiao
     * @date 2020/3/9 19:47
     */
    public void push(int x) {
        int count = queue.size();//看当前队列有几个元素
        queue.offer(x);
        for (int i = 0; i < count; i++) {
            queue.offer(queue.poll());//队列中的元素依次出队再入队
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}