package entity;

/**
 * @author WuBiao
 * @date 2020/4/3 16:35
 */
public class Node {

    public int val;
    public Node left;
    public Node right;

    private Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
