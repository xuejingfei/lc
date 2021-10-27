package list;

public class ReverseKList {

    /**
     * 以K个为一组反转单链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKList(ListNode head, int k) {
        if (head == null || head.next ==null) return head;
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        ListNode end = dump;
        while (end.next !=null) {
            for(int i =0;i<k && end!=null;i++) {
                end = end.next;
            }
            if (end == null) break;
            //保存k值下一个节点
            ListNode next = end.next;
            //截断
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverseList(start);
            //重新连起来
            start.next = next;
            pre = start;
            end = start;
        }
        return dump.next;
    }


    private ListNode reverseList(ListNode head) {
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
