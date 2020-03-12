/**
 * @author WuBiao
 * @date 2020/3/12 22:26
 */
public class Solution {
    /**
     * @param c
     * @return boolean
     * @description 注意右端点的初始化
     * @author WuBiao
     * @date 2020/3/12 22:33
     */
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);//j初始化为sqrt（c），减少运算量
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}