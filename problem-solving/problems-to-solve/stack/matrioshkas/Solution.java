import java.util.Stack;

/**
 * Solution class to check if a sequence of nested toys forms a valid Matrioshka.
 */
public class Solution {

  /**
   * Determines if the given array of toy sizes represents a valid Matrioshka sequence.
   *
   * @param toys an array of integers, where negative numbers indicate opening a toy
   *             and positive numbers indicate closing a toy
   * @return true if the sequence is a valid Matrioshka, false otherwise
   */
  public boolean isMatrioshka(int[] toys) {
    int n = toys.length;
    if (n == 0) {
      return true;
    }
    if (n % 2 != 0) {
      return false;
    }
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (toys[i] < 0) {
        st.push(toys[i]);
      } else {
        // if positive
        int sum = 0;
        while (true) {
          if (st.empty()) {
            return false;
          }
          if (st.peek() < 0) {
            int absPeek = -1 * st.peek();
            // if closing another toy
            if (absPeek != toys[i]) {
              return false;
            } else {
              if (sum >= toys[i]) {
                return false;
              }
              st.pop();
              st.push(toys[i]);
              break;
            }
          }
          sum += st.peek();
          st.pop();
        }
      }
    }

    return st.size() == 1 && st.peek() > 0;
  }
}
