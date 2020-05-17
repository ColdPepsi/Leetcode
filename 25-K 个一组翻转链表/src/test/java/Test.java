import entity.ListNode;

/**
 * @author WuBiao
 * @date 2020/5/16 14:07
 */
public class Test {
    Solution solution=new Solution();

    @org.junit.Test
    public void test(){
        ListNode head=SingleLinkedList.generateAList(new int[]{1,2,3,4,5});
        solution.reverseKGroup(head,3);
    }
}
