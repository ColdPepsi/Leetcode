import java.util.ArrayList;
import java.util.List;

/**
 * @author wubiao21 2020年07月09日 17:43:45
 */
public class Solution {

    /**
     * DFS实现BFS,这是通用方法，117题也可以解决
     *
     * @param root 根节点
     * @return 处理好的根节点
     */
    public Node connect(Node root) {
        dfs(root, 0, new ArrayList<>());
        return root;
    }

    /**
     * 先序遍历
     *
     * @param root  当前遍历的结点
     * @param level 当前结点所在的层高
     * @param rears 尾指针数组，因为用尾插法需要记录尾指针
     */
    private void dfs(Node root, int level, List<Node> rears) {
        if (root == null) {
            return;
        }
        if (rears.size() <= level) {//没有尾指针直接加入
            rears.add(root);
        } else {//如果该层存在尾指针，加到后面
            rears.get(level).next = root;
            rears.set(level, root);//更新尾指针
        }
        dfs(root.left, level + 1, rears);//递归处理左孩子
        dfs(root.right, level + 1, rears);//递归处理右孩子
    }
}