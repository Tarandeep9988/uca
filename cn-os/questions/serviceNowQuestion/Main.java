
public class Main {
  public static int getMaxSeq(String s, int k) {
    int maxLen = 0;
    int n = s.length();
    for (char ch = 'A'; ch <= 'Z'; ch++) {
      // Applying sliding window for each character
      int cnt = 0;
      int l = 0;
      int r = 0;
      while (r < n) {
        if (s.charAt(r) == ch) {
          r++;
        }
        else {
          if (cnt < k) {
            r++;
            cnt++;
          }
          else {
            if (s.charAt(l) == ch) {
              l++;
            }
            else {
              l++;
              cnt--;
            }
          }

        }
        maxLen = Math.max(maxLen, r - l);
      }
    }
    return maxLen;
  }
  public static void main(String[] args) {
    int n = getMaxSeq("AABABBA", 1);
    System.out.println(n);
  }
}
