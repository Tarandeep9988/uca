
import java.util.Stack;
public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int maxi = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            }
            else {
                st.pop();
                if (st.empty()) {
                    st.push(i);
                }
                else {
                    maxi = Math.max(maxi, i - st.peek());
                }
            }
        }
        return maxi;
    }
}
