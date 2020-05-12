import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/8 21:40
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postOrder(child, res);
        }
        res.add(root.val);
    }
}