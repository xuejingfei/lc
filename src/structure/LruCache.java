package structure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {


    class DLinkNode {
        public DLinkNode pre;
        public DLinkNode next;
        public int val;
        public int key;

        public DLinkNode(){

        }
        public DLinkNode(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private int size = 0;

    private Map<Integer,DLinkNode> map = new HashMap<Integer,DLinkNode>();
    private DLinkNode head,tail;

    LruCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node != null) {
            removeNode(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void addToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key,int value) {
        DLinkNode oldNode = map.get(key);
        if (oldNode != null) {
            oldNode.val = value;
            removeNode(oldNode);
            addToHead(oldNode);
        } else {
            DLinkNode node = new DLinkNode(key,value);
            map.put(key,node);
            addToHead(node);
            ++size;
            if (size>capacity) {
                DLinkNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        }
    }


    private DLinkNode removeTail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }


    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
