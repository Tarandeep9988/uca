import java.util.Stack;

/**
 * Solution class to check if parentheses and brackets in a string are balanced.
 */
public class Solution {

    /**
     * Checks if the input string has balanced parentheses '(' and ')' and brackets '[' and ']'.
     *
     * @param str the input string containing parentheses and brackets
     * @return true if the string is balanced, false otherwise
     */
    public boolean parenthesisBalance(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(') {
                st.push(ch);
            } else if (ch == ']' && !st.empty() && st.peek() == '[') {
                st.pop();
            } else if (ch == ')' && !st.empty() && st.peek() == '(') {
                st.pop();
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
