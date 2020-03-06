import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/3/4 22:30
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = getLength(root);
        int width = len / k;
        int left = len % k;//剩下的元素，放在前len%k個組中，每組多放一個。
        ListNode currentNode = root;
        for (int i = 0; i < k && currentNode != null; i++) {
            //一共k组，每组分别处理
            res[i] = currentNode;
            int currentsize = (width + ((left-- > 0) ? 1 : 0));//当前组的长度
            for (int j = 0; j < currentsize - 1; j++) {
                //循环结束后，currentNode指向当前组的最后一个结点。
                currentNode = currentNode.next;
            }
            ListNode newHead = currentNode.next;
            currentNode.next = null;
            currentNode = newHead;
        }
        return res;
    }


    /**
     * @param head
     * @return int
     * @description 获取链表长度
     * @author WuBiao
     * @date 2020/3/4 22:54
     */
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
