/**
 * 类Solution2.java的实现描述：尝试递归写法，效率慢
 *
 * @author wubiao21 2020年07月08日 09:18:33
 */
public class Solution2 {

    private int[] res;

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        res = new int[k + 1];
        divingBoard2(shorter, longer, k);
        return res;
    }

    public void divingBoard2(int shorter, int longer, int k) {
        if (k == 1) {
            res[0] = shorter;
            res[1] = longer;
            return;
        }
        divingBoard2(shorter, longer, k - 1);
        for (int i = 0; i < k; i++) {//此循环每次递归都会执行，所以效率很慢
            res[i] = res[i] + shorter;//每个选择后面再加一个短木板
        }
        res[k] = longer * k;//最后再加上一个k个长木板
    }
}