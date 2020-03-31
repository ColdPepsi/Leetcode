import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/3/31 17:33
 */
public class Solution {

    Set<Integer> col = new HashSet<Integer>();//存储有没有列冲突
    Set<Integer> main = new HashSet<Integer>();//存储主对角线有没有冲突，同一主对角线上，横纵坐标差相等
    Set<Integer> secondary = new HashSet<Integer>();//存储负对角线有没有冲突，同一副对角线上，横纵坐标和相等


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n != 0) {
            backTracking(res, new ArrayList<Integer>(), 0, n);
        }
        return res;
    }

    /**
     * @param prefix
     * @param n
     * @return java.util.List<java.lang.String>
     * @description 把结果构造成需要的形式
     * @author WuBiao
     * @date 2020/3/31 17:59
     */
    private List<String> print(List<Integer> prefix, int n) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < n; i++) {//每次处理一行
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(".");
            }
            row.replace(prefix.get(i), prefix.get(i) + 1, "Q");//把相应位置换成Q
            res.add(row.toString());
        }
        return res;
    }

    /**
     * @param res
     * @param prefix
     * @param row
     * @param n
     * @return void
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/31 17:59
     */
    private void backTracking(List<List<String>> res, List<Integer> prefix, int row, int n) {
        if (prefix.size() == n) {//找到结果
            res.add(print(prefix, n));//保存结果
            return;
        }
        for (int i = 0; i < n; i++) {//对第row行进行测试
            if (!col.contains(i) && !main.contains(row - i) && !secondary.contains(row + i)) {
                //若放在第i列没有冲突
                prefix.add(i);//放入结果集
                col.add(i);//保存状态
                main.add(row - i);
                secondary.add(row + i);

                backTracking(res, prefix, row + 1, n);//向下行递归

                secondary.remove(row + i);//恢复现场，用于本行下一种可能的测试
                main.remove(row - i);
                col.remove(i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }
}