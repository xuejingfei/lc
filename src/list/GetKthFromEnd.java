package list;

public class GetKthFromEnd {


    /**
     * 链表中倒数第k个节点
     * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head,int k) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i =0;i<k;i++) {
            fast = fast.next;
        }

        while (fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
