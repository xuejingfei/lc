package list;



public class DeleteDuplicates {


    /**
     * 删除排序链表中的重复元素
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 关键点：
     * 1.借用虚拟节点保存头节点
     * 因为是升序，相同出现的位置是连续的
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while (cur.next !=null && cur.next.next !=null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next !=null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


}
