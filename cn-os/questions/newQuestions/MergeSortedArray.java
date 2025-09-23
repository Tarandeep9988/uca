public class MergeSortedArray {
  public static int[] mergeSortedArray(int[] nums1, int[] nums2, int n, int m) {
    int size = n + m - 1;
    n--;
    m--;
    while (n >= 0 && m >= 0) {
      if (nums1[n] > nums2[m]) {
        nums1[size--] = nums1[n--];
      }
      else {
        nums1[size--] = nums2[m--];
      }
    }
    while (m >= 0) {
      nums1[size--] = nums2[m--];
    }
    return nums1;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 3, 5, 6, 10, 0, 0, 0, 0}; // size = 5 , actual size = 9;
    int[] nums2 = {7, 8, 9, 200}; // actual size = 4;
    mergeSortedArray(nums1, nums2, 5, 4);
    for (int e : nums1) {
      System.out.print(e + " ");
    }
    System.out.println();
  }
}
