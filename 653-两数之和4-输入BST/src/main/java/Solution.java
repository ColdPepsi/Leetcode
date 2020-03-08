import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/8 20:16
 */
public class Solution {
    /**
     * @param root
     * @param k
     * @return boolean
     * @description 先中序遍历BST获取有序数组，然后用双指针法
     * @author WuBiao
     * @date 2020/3/8 20:29
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> vals = new ArrayList<Integer>();//存放遍历结果
        inOrder(root, vals);
        int i = 0, j = vals.size() - 1;
        while (i < j) {
            int temp = vals.get(i) + vals.get(j);
            if (temp == k) {
                return true;
            } else if (temp < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     * @param root
     * @param vals
     * @return void
     * @description 中序遍历BST，把遍历结果放入vals数组中
     * @author WuBiao
     * @date 2020/3/8 20:20
     */
    private void inOrder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inOrder(root.left, vals);
        vals.add(root.val);
        inOrder(root.right, vals);
    }
}