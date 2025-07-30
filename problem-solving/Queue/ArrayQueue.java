package Queue;


public class ArrayQueue {
    private int capacity;
    int head, tail, size;
    int[] arr;
    public ArrayQueue(int c) {
        capacity = c;
        head = tail = -1;
        arr = new int[capacity];
        size = 0;
    }
    public void add(int ele) {
        tail = (tail + 1) % capacity;
        arr[tail] = ele;
        size++;
    }
    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        size--;
        head = (head + 1) % capacity;
        return arr[head];
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
