package list;

public class ListNode {
    ListNode next;
    int val;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int value,ListNode next){
        this.val = value;
        this.next = next;
    }
}
