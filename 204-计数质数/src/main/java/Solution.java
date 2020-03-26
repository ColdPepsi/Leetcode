/**
 * @author WuBiao
 * @date 2020/3/26 15:20
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 埃氏筛选法
     * @author WuBiao
     * @date 2020/3/26 15:27
     */
    public int countPrimes(int n) {
        boolean[] isNotPrimes = new boolean[n + 1];//若i为质数，则isNotPrimes[i]==false；
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isNotPrimes[i]) {
                continue;//isNotPrimes[i]==true，表示i不是指数，不是质数则跳过
            }
            count++;//是质数则count++
            for (int j = 2 * i; j < n; j += i) {//把i的所有倍数，标记为非质数
                isNotPrimes[j] = true;
            }
        }
        return count;
    }
}