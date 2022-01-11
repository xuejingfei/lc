package list;

public class AddTwoNumbers {

    /**
     *
     * 两数相加
     * Link：https://leetcode-cn.com/problems/add-two-numbers/
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1!=null || l2!=null) {
            int v1 = l1!=null ? l1.val : 0;
            int v2 = l2!=null ? l2.val : 0;
            int sum = v1+v2 + carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            if (l1 !=null) l1 = l1.next;
            if (l2 !=null) l2 = l2.next;
            cur = cur.next;

        }

        if (carry>0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
