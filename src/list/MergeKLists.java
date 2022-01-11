package list;

import java.util.PriorityQueue;

public class MergeKLists {

    class Status implements Comparable<Status>{
        ListNode node;
        int value;

        public Status(ListNode node,int value) {
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Status o) {
            return this.value - o.value;
        }
    }

    private PriorityQueue<Status> queue = new PriorityQueue<>();
    /**
     *
     *
     * 合并k个升序链表
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
       for (ListNode node:lists) {
           if (node !=null) {
               queue.offer(new Status(node,node.val));
           }
       }
       ListNode dummp = new ListNode(-1);
       ListNode cur = dummp;
       while (!queue.isEmpty()) {
           ListNode top = queue.poll().node;
           cur.next = top;
           cur = cur.next;
           if (top!=null) {
               queue.offer(new Status(top.next,top.next.val));
           }
       }
       return dummp;
    }
}
