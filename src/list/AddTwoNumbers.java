package list;

public class AddTwoNumbers {

    /**
     * 两个链表之和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummp = new ListNode(-1);
        ListNode tail = dummp;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum  = v1 + v2 + carry;
            int value = sum %10;
            tail.next = new ListNode(value);
            carry = sum/10;
            tail = tail.next;
            if (l1 !=null) l1 = l1.next;
            if (l2 !=null) l2 = l2.next;
        }
        if (carry>0) {
            tail.next = new ListNode(carry);
        }
        return dummp.next;
    }
}
