public class SearchInRotatedSortedArrayWithDuplicates {
  /**
   * Given a sorted array that is rotated at some pivot and may contain duplicates, find the index of a target value. If the target is not found, return -1.
   *
   * Example: [2, 5, 6, 0, 0, 1, 2], target = 0 -> returns 3 or 4.
   *
   * @param nums - Rotated sorted integer array (may contain duplicates).
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
      // If there are duplicates we can't fully check if left subarray is sorted or right one, if such a condition hit trim the array
      
      if (nums[mid] == nums[l] && nums[mid] == nums[r]) {
        l++;
        r--;
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
   * Main method for testing the SearchInRotatedSortedArrayWithDuplicates class.
   */
  public static void main(String[] args) {
    SearchInRotatedSortedArrayWithDuplicates s = new SearchInRotatedSortedArrayWithDuplicates();
    int[] arr1 = {2, 5, 6, 0, 0, 1, 2};
    assert (s.search(arr1, 0) == 3 || s.search(arr1, 0) == 4) : "Test case 1 failed";
    int[] arr2 = {2, 2, 2, 3, 4, 2};
    assert s.search(arr2, 3) == 3 : "Test case 2 failed";
    assert s.search(arr2, 5) == -1 : "Test case 3 failed";
  }
}
