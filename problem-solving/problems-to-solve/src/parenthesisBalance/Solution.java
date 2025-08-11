import java.util.Stack;

public class Solution {
	public boolean parenthesisBalance(String str) {
		Stack<Character> st = new Stack<>();
		int n = str.length();
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == '[' || ch == '(') {
				st.push(ch);
			}
			else if (ch == ']' && !st.empty() && st.peek() == '[') {
				st.pop();
			}
			else if (ch == ')' && !st.empty() && st.peek() == '(') {
				st.pop();
			}
			else {
				return false;
			}
		}
		return st.isEmpty();
	}
}
