
public class LLQueue {
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this(val, null);
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private int size;
    Node front, rear;


    // Default Constructor
    public LLQueue() {
        front = rear = null;
        size = 0;
    }

    // add -> add element at back
    public void add(int ele) {
        if (size == 0) {
            front = rear = new Node(ele);
            size++;
            return;
        }
        rear.next = new Node(ele);
        rear = rear.next;
        size++;
    }

    // remove -> remove element from front and return it
    public int remove() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");;
            return -1;
        }
        int ele = front.val;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return ele;
    }

    // peek -> returns front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
            return -1;
        }
        return front.val;
    }

    // isEmpty -> Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // size -> returns size of queue
    public int size() {
        return size;
    }
}