package list;

public class RotateRight {

    /**
     * 向右旋转单链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head,int k) {
        if (head ==null || k<=0 || head.next ==null) return head;
        ListNode tail = head;
        int n = 1;
        while (tail.next!=null) {
            tail = tail.next;
            n++;
        }
        tail.next = head;
        int kth = n-k%n-1;
        while (kth>0) {
            head = head.next;
            kth--;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}
