/**
 * @author WuBiao
 * @date 2020/3/30 17:38
 */
public class Solution {
    /**
     * @param num
     * @return int[]
     * @description n&(n-1) 去除 n 的位级表示中最低的那一位 1。
     * 例如对于二进制表示 01011011，减去 1 得到 01011010，这两个数相与得到 01011010。
     * @author WuBiao
     * @date 2020/3/30 17:41
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}