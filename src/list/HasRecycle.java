package list;

public class HasRecycle {


    /**
     * 是否有环
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param head
     * @return
     */
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
