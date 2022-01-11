package list;

public class ReverseKList {

    /**
     * 以K个为一组反转单链表
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKList(ListNode head, int k) {
        if (head ==null || head.next ==null) return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next!=null) {
            for(int i =0;i<k && end!=null;i++) {
                end = end.next;
            }
            if (end == null) break;

            //保存k组之后的节点
            ListNode kNext = end.next;

            //截断k个节点的链表进行反转(KStart, end)
            ListNode KStart = pre.next;
            end.next = null;
            ListNode reverseKStart = reverseList(KStart);

            //反转后重新链接(pre链接反转之后的head节点，反转之后的尾结点链接下一个k组的头结点)
            pre.next = reverseKStart;
            KStart.next = kNext;

            pre = KStart;
            end = KStart;
        }

        return dummy.next;

    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
