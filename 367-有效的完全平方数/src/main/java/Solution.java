/**
 * @author WuBiao
 * @date 2020/3/28 19:15
 */
public class Solution {
    /**
     * @param num
     * @return boolean
     * @description 完全平方序列的间隔差是等差数列
     * @author WuBiao
     * @date 2020/3/28 19:21
     */
    public boolean isPerfectSquare(int num) {
        int sub = 1;
        while (num > 0) {
            num -= sub;
            sub += 2;
        }
        return num == 0;
    }
}
//完全平方序列：1，4，9，16，25
//中间的差分别为：3，5，7，9
//中间的差是等差数列
//完全平方数可以通过累加从1往后的奇数找到，
//
//1 = 1;
//4 = 1 + 3;
//9 = 1 + 3 + 5;
//16 = 1 + 3 + 5 + 7;