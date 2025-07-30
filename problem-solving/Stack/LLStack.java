package Stack;

public class LLStack {

    class Node {
        int val;
        Node next;
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private int size;
    Node head;
    public LLStack() {
        size = 0;
        head = null;
    }
    public void push(int ele) {
        head = new Node(ele, head);
        size++;
    }
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int val = head.val;
        head = head.next;
        return val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}