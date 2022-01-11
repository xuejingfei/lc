package list;

public class GetIntersectionNode {


    /**
     * 链表相交
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB ==null)return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA != null ? tempA.next :  headB;
            tempB = tempB != null ? tempB.next : headA;
        }
        return tempA;
    }
}
