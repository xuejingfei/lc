package divideConquer;

import list.ListNode;

public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKLists(lists,0,lists.length-1);
    }


    public ListNode mergeKLists(ListNode[] lists,int i,int j) {
        if (i == j) return lists[i];
        int middle = (i+j)/2;
        return mergeTwoList(mergeKLists(lists,i,middle),mergeKLists(lists,middle+1,j));
    }


    public ListNode mergeTwoList(ListNode l1,ListNode l2) {
        ListNode dummp = new ListNode(-1);
        ListNode current = dummp;
        while (l1 !=null && l2!=null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 !=null) {
            current.next = l1;
        }
        if (l2!=null) {
            current.next = l2;
        }
        return dummp.next;
    }
}
