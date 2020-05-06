import java.util.HashSet;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/4/19 21:05
 */
public class Solution {

    private int res = 0;

    public int totalNQueens(int n) {
        if (n < 2) {
            return n;
        }
        backTracking(0, n, new HashSet<Integer>(2 * n),
                new HashSet<Integer>(3 * n),
                new HashSet<Integer>(3 * n));
        return res;
    }

    /**
     * @param row    当前行号
     * @param n      皇后个数
     * @param col    存储列冲突
     * @param main   主对角线冲突
     * @param second 副对角线冲突
     * @return void
     * @description 回溯
     * @author WuBiao
     * @date 2020/4/19 21:37
     */
    private void backTracking(int row, int n, Set<Integer> col,
                              Set<Integer> main, Set<Integer> second) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {//在row行的每个坐标尝试
            if (!col.contains(i) && !main.contains(row - i) && !second.contains(row + i)) {
                col.add(i);
                main.add(row - i);
                second.add(row + i);

                backTracking(row + 1, n, col, main, second);//尝试下一行

                second.remove(row + i);//恢复现场
                main.remove(row - i);
                col.remove(i);
            }
        }
    }
}