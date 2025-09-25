public class SearchInRotatedSortedArray {
  /**
   * Given a sorted array that is rotated at some pivot (with no duplicate values), find the index of a target value. If the target is not found, return -1.
   *
   * Example: [4, 5, 6, 7, 0, 1, 2], target = 0 -> returns 4.
   *
   * @param nums - Rotated sorted integer array (no duplicates).
   * @param target - The integer to search for.
   * @returns int - Index of target or -1 if not found.
   */
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // Check if left is sorted
      else if (nums[l] <= nums[mid]) {
        // Target may or not exist here
        if (nums[l] <= target && target <= nums[mid]) {
          // go left
          r = mid - 1;
        }
        else {
          // go right
          l = mid + 1;
        }
      }
      // right should be sorted
      else {
        // Target may or may not exist in right part
        if (nums[mid] <= target && target <= nums[r]) {
          // go right
          l = mid + 1;
        }
        else {
          // go left
          r = mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * Main method for testing the SearchInRotatedSortedArray class.
   */
  public static void main(String[] args) {
    SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
    int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
    assert s.search(arr1, 0) == 4 : "Test case 1 failed";
    assert s.search(arr1, 3) == -1 : "Test case 2 failed";
    int[] arr2 = {3, 1};
    assert s.search(arr2, 3) == 0 : "Test case 3 failed";
  }
}
