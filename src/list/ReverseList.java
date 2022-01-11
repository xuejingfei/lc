package list;

public class ReverseList {

    /**
     * 反转单链表
     * https://leetcode-cn.com/problems/UHnkqh/
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     */
    public ListNode reverseList(ListNode head) {
       ListNode pre = null;
       ListNode cur = head;
       while (cur !=null) {
           ListNode next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
       }
       return pre;
    }
}
