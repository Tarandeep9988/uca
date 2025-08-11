import java.util.HashMap;
import java.util.Stack;

public class Solution {
	public String infixToPostfix(String s) {
		HashMap<Character, Integer> precedence = new HashMap<>();
        	precedence.put('/', 2);
        	precedence.put('*', 2);
       		precedence.put('+', 1);
	        precedence.put('-', 1);
        	precedence.put('(', 0);

		int n = s.length();
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				// operand
				sb.append(ch);
			}
			else if (ch == '(') {
				st.push(ch);
			}
			else if (ch == ')') {
				while(st.peek() != '(') {
					sb.append(st.pop());
				}
				st.pop();
			}
			else {
				// must be a operator
				while (!st.empty() && precedence.get(st.peek()) >= precedence.get(ch)) {
					sb.append(st.pop());
				}
				st.push(ch);
			}
		}

		while (!st.empty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}
}
