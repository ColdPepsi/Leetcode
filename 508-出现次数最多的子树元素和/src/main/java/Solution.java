import entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wubiao21 2020年07月06日 18:45:07
 */
public class Solution {

    private int max;//记录最大次数

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> count = new HashMap<>();//用来记录每个子树和出现的次数
        max = -1;
        List<Integer> res = new ArrayList<>();
        calculateSum(root, count, res);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    /**
     * 后序遍历
     *
     * @param root  根结点
     * @param count 保存次数的map
     * @return root的子树和
     */
    private int calculateSum(TreeNode root, Map<Integer, Integer> count, List<Integer> res) {
        if (root == null) {
            return 0;
        }
        int sum = calculateSum(root.left, count, res) + calculateSum(root.right, count, res) + root.val;
        int CurrentCount = count.getOrDefault(sum, 0) + 1;
        count.put(sum, CurrentCount);
        if (CurrentCount >= max) {
            if (CurrentCount > max) {
                max = CurrentCount;//更新最大值
                res.clear();//清空结果集
            }
            res.add(sum);//放入新值
        }
        return sum;
    }
}