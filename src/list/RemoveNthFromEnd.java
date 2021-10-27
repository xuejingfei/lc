package list;

public class RemoveNthFromEnd {

    /**
     * 删除倒数第N的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head,int n) {
        ListNode dummp = new ListNode(-1,head);
        ListNode slow = dummp;
        ListNode fast = dummp;
        for(int i=0;i<=n;i++) {
            fast = fast.next;
        }

        while (fast !=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummp.next;
    }
}
