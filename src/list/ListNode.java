package list;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int value,ListNode next){
        this.val = value;
        this.next = next;
    }
}
