/**
 * @author WuBiao
 * @date 2020/6/19 22:54
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 利用与运算短路
     * @author WuBiao
     * @date 2020/6/19 22:55
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
