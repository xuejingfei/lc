package list;

public class MergeTwoLists {

    /**
     * 合并两个升序链表
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     */
    private ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummp = new ListNode(-1);
        ListNode tail = dummp;
        while (l1 !=null && l2!=null){
            if (l1.val<l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) tail.next = l2;
        if (l2 == null) tail.next = l1;

        return dummp.next;
    }
}
