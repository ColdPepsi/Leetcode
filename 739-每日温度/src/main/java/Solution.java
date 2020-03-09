import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/9 21:31
 */
public class Solution {
    /**
     * @param T
     * @return int[]
     * @description 在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数就是当前元素。
     * @author WuBiao
     * @date 2020/3/9 21:49
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        Stack<Integer> index = new Stack<Integer>();//用来存储T中每个没找到下一个比它大的元素的下标
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {//对T中的每个元素做处理
            while (!index.isEmpty() && T[i] > T[index.peek()]) {
                //如果当前元素比栈顶元素大，说明栈顶元素下一个比它大的元素就是当前元素
                res[index.peek()] = i - index.peek();//res存储结果后，栈顶出栈
                index.pop();
            }
            index.push(i);
        }
        return res;
    }
}