import java.util.Stack;

class Solution {
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
