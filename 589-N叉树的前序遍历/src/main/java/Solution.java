import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/14 22:28
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            preorder(res, child);
        }
    }
}