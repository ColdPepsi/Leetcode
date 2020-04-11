import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/4 17:05
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<Integer>();
        reverse(head, res);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void reverse(ListNode head, List<Integer> res) {
        if (head == null) {
            return;
        }
        reverse(head.next, res);
        res.add(head.val);
    }
}