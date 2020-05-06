import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/4/28 19:20
 */
public class Test {
    Solution solution=new Solution();

    @org.junit.Test
    public void test(){
        ListNode head = SingleLinkedList.generateAList(new int[]{1, 2, 3, 4, 5});
        SingleLinkedList.traversal(head);
        ListNode node = solution.rotateRight(head, 2);
        SingleLinkedList.traversal(node);
    }
}