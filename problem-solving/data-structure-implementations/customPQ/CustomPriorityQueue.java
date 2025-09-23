import java.util.Arrays;
import java.util.Comparator;

/**
 * A CustomPriorityQueue class.
 *
 * <p>
 * Supports insertion, deletion of the maximum element,
 * peeking at the maximum key, checking if the queue is empty,
 * and retrieving the number of elements.
 *
 */

public class CustomPriorityQueue<T extends Comparable<T>> {
  private static final int DEFAULT_INITIAL_CAPACITY = 10; // default capacity
  private Object[] pq; // binary heap using 1-based indexing
  private int size; // number of elements in the queue
  private Comparator<T> comparator;

  /**
   * Initializes an empty priority queue with default capacity
   * 
   * @param capacity
   */

  public CustomPriorityQueue() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  /**
   * Initializes an empty priority queue.
   * 
   * @param capacity initial size of the queue.
   */
  public CustomPriorityQueue(int capacity) {
    this.pq = new Object[capacity + 1];
    this.size = 0;
  }

  /**
   * Initializes an empty priority queue with a comparator
   */
  public CustomPriorityQueue(int capacity, Comparator<T> comparator) {
    this(capacity);
    this.comparator = comparator;
  }

  /**
   * Returns true if queue is empty.
   * 
   * @return true if queue is empty,
   *         false otherwise
   * 
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the size of queue.
   * 
   * @return the number of items in the queue
   */
  public int size() {
    return this.size;
  }

  // Helper function.
  private void swap(int i, int j) {
    Object temp = this.pq[i];
    this.pq[i] = this.pq[j];
    this.pq[j] = temp;
  }

  // Helper function.
  @SuppressWarnings("unchecked")
  private boolean less(int i, int j) {
    if (comparator != null) {
      return comparator.compare((T) this.pq[i], (T) this.pq[j]) > 0;
    }
    return ((T) this.pq[i]).compareTo((T) this.pq[j]) < 0;
  }

  /**
   * Inserts an element into the queue
   * and if needed adjusts the array
   * elementsto ensure binary heap order
   * for max queue is maintained.
   */

  public void insert(T x) {
    // If pq is full
    if (size == pq.length - 1) {
      resize(pq.length + (pq.length >> 1));
    }
    this.pq[++size] = x;
    swim(size);
  }

  // helper function to change size
  private void resize(int newSize) {
    pq = Arrays.copyOf(pq, newSize);
  }

  // Swims an elemnt up to its rightful position
  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      swap(k / 2, k);
      k /= 2;
    }
  }

  /**
   * Returns and delete the maximum element in queue.
   *
   * @return maximum element in the queue.
   */
  @SuppressWarnings("unchecked")
  public T poll() {
    if (this.isEmpty()) {
      return null;
    }
    T elem = (T) this.pq[1];
    swap(1, size--);
    sink(1);
    if (size <= this.pq.length / 4 && size > DEFAULT_INITIAL_CAPACITY) {
      resize(this.pq.length / 2);
    }
    return elem;
  }

  // Sink an element from the top to its
  // rightful position
  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;

      if (j + 1 <= size && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      swap(k, j);
      k = j;
    }
  }

  /**
   * Driver code to test.
   */
  public static void main(String[] args) {
    // ---------- 1. Default constructor ----------
    CustomPriorityQueue<Integer> pqDefault = new CustomPriorityQueue<>();
    pqDefault.insert(5);
    pqDefault.insert(1);
    pqDefault.insert(9);
    assert pqDefault.size() == 3;
    assert pqDefault.poll() == 9;
    assert pqDefault.poll() == 5;
    assert pqDefault.poll() == 1;
    assert pqDefault.isEmpty();

    // ---------- 2. Constructor with initial capacity ----------
    CustomPriorityQueue<Integer> pqCapacity = new CustomPriorityQueue<>(3);
    pqCapacity.insert(2);
    pqCapacity.insert(3);
    pqCapacity.insert(1);
    assert pqCapacity.size() == 3;
    assert pqCapacity.poll() == 3;
    assert pqCapacity.poll() == 2;
    assert pqCapacity.poll() == 1;
    assert pqCapacity.isEmpty();

    // ---------- 3. Constructor with initial capacity + Comparator (min-heap)
    // ----------
    CustomPriorityQueue<Integer> pqComparator = new CustomPriorityQueue<>(5, (a, b) -> a - b);
    pqComparator.insert(10);
    pqComparator.insert(3);
    pqComparator.insert(7);
    pqComparator.insert(1);
    assert pqComparator.size() == 4;

    // min-heap behavior: smallest element comes out first
    assert pqComparator.poll() == 1;
    assert pqComparator.poll() == 3;
    assert pqComparator.poll() == 7;
    assert pqComparator.poll() == 10;
    assert pqComparator.isEmpty();

    // ---------- Extra test: mix insertions after empty ----------
    pqComparator.insert(42);
    pqComparator.insert(20);
    assert pqComparator.size() == 2;
    assert pqComparator.poll() == 20;
    assert pqComparator.poll() == 42;
    assert pqComparator.isEmpty();

    System.out.println("All test cases passed for all constructors!");
  }
}
