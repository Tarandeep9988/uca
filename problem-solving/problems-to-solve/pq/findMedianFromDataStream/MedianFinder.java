import java.util.PriorityQueue;

/**
 * MedianFinder object will be instantiated.
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * Will work in log2(N) time for each element.
 */

public class MedianFinder {
  PriorityQueue<Integer> maxPQ;
  PriorityQueue<Integer> minPQ;
  // Two pq will work like a sorted array having break in between
  public MedianFinder() {
    minPQ = new PriorityQueue<>(); // by default minPQ
    maxPQ = new PriorityQueue<>((a, b) -> b - a); // custom comparator for maxPQ
  }

  public void addNum(int num) {
    maxPQ.add(num);
    balance();
  }

  public double findMedian() {
    if (maxPQ.size() == minPQ.size()) {
      double mean = (maxPQ.peek() + minPQ.peek()) / 2d;
      return Math.round(mean * 1e5) / 1e5;
    }
    return maxPQ.peek();
  }
  private void balance() {
    if (maxPQ.size() - minPQ.size() == 2) {
      minPQ.add(maxPQ.remove());
    }
    if (!minPQ.isEmpty()) {
      if (maxPQ.peek() > minPQ.peek()) {
        int a = maxPQ.remove();
        int b = minPQ.remove();
        maxPQ.add(b);
        minPQ.add(a);
      }
    }
  }
}

