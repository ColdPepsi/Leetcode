import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/5/17 20:28
 */
public class MaxQueue {

    private final Queue<Integer> numQueue;
    private final Deque<Integer> maxQueue;

    public MaxQueue() {
        numQueue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.getFirst();
    }

    public void push_back(int value) {
        numQueue.offer(value);
        if (!maxQueue.isEmpty()) {
            if (value >= maxQueue.getFirst()) {
                maxQueue.clear();
            } else {
                while (value > maxQueue.getLast()) {
                    maxQueue.pollLast();
                }
            }
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        int temp = numQueue.poll();
        if (temp == maxQueue.getFirst()) {
            maxQueue.pollFirst();
        }
        return temp;
    }
}