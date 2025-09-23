import java.util.Stack;

/**
 * Solution class provides a method to compute the largest rectangle area in a histogram.
 */
class Solution {

  /**
   * Computes the area of the largest rectangle that can be formed in a histogram
   * represented by an array of heights.
   * <p>
   * The method uses a stack-based approach to find:
   * <ul>
   *     <li>Next smaller element (NSE) for each bar</li>
   *     <li>Previous smaller element (PSE) for each bar</li>
   * </ul>
   * The width of the rectangle at each bar is determined using NSE and PSE,
   * and the maximal area is calculated.
   * </p>
   *
   * @param heights an array of non-negative integers representing the heights of histogram bars
   * @return the area of the largest rectangle in the histogram
   */
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;

    int[] nse = new int[n]; // next smaller element
    int[] pse = new int[n]; // previous smaller element

    Stack<Integer> st = new Stack<>();

    // Finding next smaller element
    for (int i = n - 1; i >= 0; i--) {
      while (!st.empty() && heights[st.peek()] >= heights[i]) st.pop();
      nse[i] = st.empty() ? n : st.peek();
      st.push(i);
    }

    st.clear();
    // Finding previous smaller element
    for (int i = 0; i < n; i++) {
      while (!st.empty() && heights[st.peek()] >= heights[i]) st.pop();
      pse[i] = st.empty() ? -1 : st.peek();
      st.push(i);
    }

    int maxArea = 0;
    for (int i = 0; i < n; i++) {
      int height = heights[i];
      int width = nse[i] - pse[i] - 1;
      maxArea = Math.max(maxArea, height * width);
    }
    return maxArea;
  }
}
