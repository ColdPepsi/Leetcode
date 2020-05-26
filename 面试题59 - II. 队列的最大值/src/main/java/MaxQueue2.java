/**
 * @author WuBiao
 * @date 2020/5/17 21:14
 */
public class MaxQueue2 {

    private final int[] nums;
    private int front;
    private int rear;

    public MaxQueue2() {
        nums = new int[10010];
        front = 0;
        rear = 0;
    }

    public int max_value() {
        int max = -1;
        for (int i = front; i < rear; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public void push_back(int value) {
        nums[rear++] = value;
    }

    public int pop_front() {
        if (rear == front) {
            return -1;
        }
        return nums[front++];
    }
}
