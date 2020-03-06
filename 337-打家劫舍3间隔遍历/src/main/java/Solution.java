import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/6 15:02
 */
public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<TreeNode, Integer>();//备忘录保存结果
        return robWithMemo(root, memo);
    }

    /**
     * @param root
     * @return int 爷爷偷得钱+孙子偷得钱 与 儿子偷得钱的最大值
     * @description 带备忘录，减少计算量
     * @author WuBiao
     * @date 2020/3/6 15:22
     */
    private int robWithMemo(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {//备忘录里有，直接返回结果，减少计算量
            return memo.get(root);
        }
        int grandFather = root.val;//保存爷爷和孙子偷得钱
        if (root.left != null) {
            grandFather += robWithMemo(root.left.left, memo) + robWithMemo(root.left.right, memo);
        }
        if (root.right != null) {
            grandFather += robWithMemo(root.right.left, memo) + robWithMemo(root.right.right, memo);
        }
        int son = robWithMemo(root.left, memo) + robWithMemo(root.right, memo);//保存儿子的钱
        int res = Math.max(grandFather, son);//获取较大值
        memo.put(root, res);
        return res;
    }
}
