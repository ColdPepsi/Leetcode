/**
 * @author WuBiao
 * @date 2020/5/7 22:14
 */
public class Test {
    Solution solution=new Solution();

    @org.junit.Test
    public void test(){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.random=head.next.next;
        Node newHead=solution.copyRandomList(head);
        print(head);
        System.out.println("------");
        print(newHead);

    }

    public void print(Node head){
        while (head != null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}
