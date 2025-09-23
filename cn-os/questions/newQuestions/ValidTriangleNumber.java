import java.util.Arrays;

public class ValidTriangleNumber {

  public static int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int cnt = 0;
    for (int i = n - 1; i >= 0; i--) {
      int l = 0;
      int r = i - 1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          cnt += r - l;
          r--;
        }
        else {
          l++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    int[] nums = {2, 2, 2, 3, 4};
    int cnt = triangleNumber(nums);
    System.out.println(cnt);
  }
}
