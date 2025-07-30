package Queue;

public class LLQueue {
    class Node {
        int val;
        Node next;
        Node(int v) {
            val = v;
        }
    }

    private Node head, tail;
    private int size;

    public LLQueue() {
        head = tail = null;
        size = 0;
    }
    public void add(int v) {
        if(isEmpty()) {
            head = tail = new Node(v);
            return;
        }
        tail.next = new Node(v);
        tail = tail.next;
        size++;
    }
    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        if (size == 1) {
            int v = head.val;
            head = tail = null;
            return v;
        }
        int v = head.val;
        head = head.next;
        return v;
    }
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return head.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }

}
