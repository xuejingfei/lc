package list;

public class RotateRight {

    /**
     * 旋转链表
     * https://leetcode-cn.com/problems/rotate-list/
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head,int k) {
        //临界条件
        if (head == null || head.next==null || k<=0) return head;
        //求链表的长度
        int length = 1;
        ListNode tail = head;
        while (tail.next!=null) {
            tail = tail.next;
            length++;
        }
        //头尾相连
        tail.next = head;
        //计算余数,记住这边会多减一。目的是找到目标节点的前一位
        int kth = length - k%length-1;
        while (kth>0) {
            head = head.next;
            kth--;
        }

        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}
