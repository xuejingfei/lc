package list;

public class HasRecycle {

    public boolean isRecycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
