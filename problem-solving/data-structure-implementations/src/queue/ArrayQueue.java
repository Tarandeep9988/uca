
// Fifo 
public class ArrayQueue {
    private int front, rear, size, capacity;
    private int[] arr;

    // Parameterized Constructor
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // add -> add element at back
    public void add(int ele) {
        if (isFull()) {
            System.err.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = ele;
        size++;
    }

    // remove -> remove element from front and return it
    public int remove() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");;
            return -1;
        }
        int ele = arr[front];
        front = (front + 1) % capacity;
        size--;
        return ele;
    }

    // peek -> returns front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.err.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // isEmpty -> Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // isFull -> Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // size -> returns size of queue
    public int size() {
        return size;
    }

}