package list;

public class RemoveNthFromEnd {

    /**
     * 删除倒数第N的节点
     * https://leetcode-cn.com/problems/SLwz0R/
     * 时间复杂度：O(n)
     * 空间复杂度：O(1）
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head,int n) {
       ListNode dummy = new ListNode(-1,head);
       ListNode slow = dummy;
       ListNode fast = dummy;
       for(int i=0;i<=n;i++) {
           fast = fast.next;
       }

       while (fast!=null) {
           fast = fast.next;
           slow = slow.next;
       }

       slow.next = slow.next.next;
       return dummy.next;
    }
}
