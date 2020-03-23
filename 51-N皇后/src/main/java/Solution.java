import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/3/23 19:06
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n < 1) {
            return res;
        }
        backTracking(res, new ArrayList<Integer>(), 0, n,
                new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return res;
    }

    /**
     * @param prefix 数组中的每个数，代表放在第几列，一列放一个
     * @param n
     * @return java.util.List<java.lang.String>
     * @description 把结果转换成要求形式
     * @author WuBiao
     * @date 2020/3/23 19:21
     */
    private List<String> convertToBoard(List<Integer> prefix, int n) {
        List<String> board = new ArrayList<String>();//存放棋盘
        for (Integer num : prefix) {//每个数代表放第几列
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) {
                row.append('.');
            }
            row.replace(num, num + 1, "Q");//相应的列换成Q
            board.add(row.toString());//放入棋盘中
        }
        return board;
    }

    /**
     * @param res              结果集
     * @param prefix           保存放置的结果
     * @param row              表示处理到第几行了
     * @param n                皇后数目
     * @param col              存放有没有列冲突
     * @param counter_diagonal 存放副对角线有没有冲突
     * @param main_diagonal    存放主对角线有没有冲突
     * @return void
     * @description 主对角线上横纵坐标差不变，副对角线横纵坐标和不变!!!!!
     * @author WuBiao
     * @date 2020/3/23 19:28
     */
    private void backTracking(List<List<String>> res, List<Integer> prefix, int row, int n,
                              Set<Integer> col, Set<Integer> counter_diagonal, Set<Integer> main_diagonal) {
        if (row == n) {
            res.add(convertToBoard(prefix, n));//保存结果
            return;
        }
        for (int i = 0; i < n; i++) {//对每一列进行测试，看row行应该放在哪一列
            if (!col.contains(i) && !counter_diagonal.contains(row + i) && !main_diagonal.contains(row - i)) {
                prefix.add(i);
                col.add(i);
                main_diagonal.add(row - i);
                counter_diagonal.add(row + i);

                backTracking(res, prefix, row + 1, n, col, counter_diagonal, main_diagonal);//回溯下一行

                counter_diagonal.remove(row + i);//下面为恢复现场
                main_diagonal.remove(row - i);
                col.remove(i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }
}