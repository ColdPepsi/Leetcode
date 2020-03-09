import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/9 20:17
 */
public class MinStack {

    private Stack<Integer> dataStack;//存放栈中数据
    private Stack<Integer> minStack;//存放数据栈中的最小值
    private int minVal;//用来记录当前最小值

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        minVal = Math.min(minVal, x);//更新最小值
        minStack.push(minVal);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        minVal = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();//更新最小值
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}