package entity;


import lombok.Getter;
import lombok.Setter;

/**
 * @author WuBiao
 * @date 2020/3/3 15:44
 */
@Getter
@Setter
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode() {
    }
}
