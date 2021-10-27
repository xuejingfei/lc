package list;

public class DetectCycle {


    /**
     * 获取环形链表的入口
     * @param head
     * @return
     */
    private ListNode detectCycle(ListNode head) {
        if (head == null || head.next ==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode detectNode = head;
                while (detectNode != slow) {
                    detectNode = detectNode.next;
                    slow = slow.next;
                }
                return detectNode;
            }
        }

        return null;
    }
}
