
public class Main {
    public static void main(String[] args) {
        // Test Linked List Queue
        LLQueue llQueue = new LLQueue();
        assert llQueue.isEmpty();
        llQueue.add(10);
        llQueue.add(20);
        llQueue.add(30);
        assert llQueue.size() == 3;
        assert llQueue.peek() == 10;
        assert llQueue.remove() == 10;
        assert llQueue.peek() == 20;
        assert llQueue.size() == 2;
        assert !llQueue.isEmpty();
        llQueue.remove();
        llQueue.remove();
        assert llQueue.isEmpty();
        assert llQueue.remove() == -1; // removing from empty queue

        // Test Array Queue
        ArrayQueue arrQueue = new ArrayQueue(3);
        assert arrQueue.isEmpty();
        arrQueue.add(100);
        arrQueue.add(200);
        arrQueue.add(300);
        assert arrQueue.isFull();
        assert arrQueue.size() == 3;
        assert arrQueue.peek() == 100;
        assert arrQueue.remove() == 100;
        assert arrQueue.peek() == 200;
        assert arrQueue.size() == 2;
        assert !arrQueue.isEmpty();
        arrQueue.remove();
        arrQueue.remove();
        assert arrQueue.isEmpty();
        assert arrQueue.remove() == -1; // removing from empty queue

        System.out.println("All tests passed!");
    }
}
