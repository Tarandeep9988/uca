import java.util.PriorityQueue;

/**
 * This class finds the Kth largest element in an array. Main idea is that
 * if we use a min heap of size k, we are guaranteed that the queue contains
 * the k largest elements of the array. The root of the min heap will be the
 * kth largest element.
 * Constraints:
 * - The array can contain duplicate elements.
 * - Solution should not try to sort the entire array.
 */

public class FindKthLargest {
  /**
   * Finds the Kth largest element in the given array.
   *
   * @param nums the array of integers
   * @param k    the position of the largest element to find (1-based index)
   * @return the Kth largest element in the array
   */

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    return pq.peek();
  }
  
  /**
   * Main function to test Function.
   *
   */

  public static void main(String[] args) {
    // Test case 1
    int[] nums1 = { 3, 2, 1, 5, 6, 4 };
    int k1 = 2;
    assert findKthLargest(nums1, k1) == 5 : "Test 1 failed";

    // Test case 2
    int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k2 = 4;
    assert findKthLargest(nums2, k2) == 4 : "Test 2 failed";

    // Test case 3
    int[] nums3 = { 1 };
    int k3 = 1;
    assert findKthLargest(nums3, k3) == 1 : "Test 3 failed";

    // Test case 4
    int[] nums4 = { 2, 1 };
    int k4 = 2;
    assert findKthLargest(nums4, k4) == 1 : "Test 4 failed";

    System.out.println("All test cases passed!");
  }
}
