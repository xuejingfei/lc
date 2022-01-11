package divideConquer;

import list.ListNode;

public class SortList {

    /**
     * 排序链表
     * https://leetcode-cn.com/problems/sort-list/
     * 时间复杂度: O(nlog n)
     * 空间复杂度：O(log n)
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sortList(head,null);

    }


    public ListNode sortList(ListNode head,ListNode tail) {
        //终止条件
        if (head ==null) return null;
        if (head.next == tail) { // 头尾相相交
            head.next = null;
            return head;
        }

        //利用快慢指针计算中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast !=tail) {
                fast = fast.next;
            }
        }

        ListNode left = sortList(head,slow);
        ListNode right = sortList(slow,tail);

        return mergeList(left,right);

    }


    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeList(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 !=null && temp2!=null) {
            if (temp1.val < temp2.val) {
                cur.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                cur.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            cur = cur.next;
        }

        if (temp1!=null) cur.next = temp1;
        if (temp2!=null) cur.next = temp2;
        return dummy.next;
    }


}
