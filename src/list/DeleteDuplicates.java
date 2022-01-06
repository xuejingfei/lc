package list;


import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicates {


    /**
     * 删除排序链表中的重复元素 II
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * 关键点：
     * 1.借用虚拟节点保存头节点
     * 因为是升序，相同出现的位置是连续的
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next !=null && cur.next.next!=null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next !=null&&cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur  = cur.next;
            }
        }

        return dummy.next;
    }


}
