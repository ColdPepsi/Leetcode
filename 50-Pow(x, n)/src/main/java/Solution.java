/**
 * @author WuBiao
 * @date 2020/5/11 16:09
 */
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    /**
     * @param x
     * @param n
     * @return double
     * @description 快速幂
     * @author WuBiao
     * @date 2020/5/11 16:17
     */
    private double quickPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = quickPow(x, n / 2);
        double res = temp * temp;
        if (n % 2 == 1) {//n为奇数
            res *= x;
        }
        return res;
    }
}