import java.util.HashMap;
import java.util.Stack;

/**
 * Solution class provides a method to convert an infix expression
 * to a postfix expression using the standard operator precedence rules.
 */
public class Solution {

  /**
   * Converts a given infix expression string to its equivalent postfix expression.
   * <p>
   * The method handles:
   * <ul>
   *     <li>Operands (letters and digits) – directly appended to the output</li>
   *     <li>Operators (+, -, *, /) – pushed onto a stack respecting precedence</li>
   *     <li>Parentheses – '(' pushed onto stack, ')' pops until '('</li>
   * </ul>
   * Operator precedence is defined as: '*' and '/' have higher precedence than '+' and '-'.
   * Left-to-right associativity is used for operators of the same precedence.
   * </p>
   *
   * @param s the input infix expression (non-empty, containing only letters, digits, 
   *          operators '+', '-', '*', '/', and parentheses '(' and ')')
   * @return a string representing the postfix expression equivalent of the input
   */
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
      } else if (ch == '(') {
        st.push(ch);
      } else if (ch == ')') {
        while (st.peek() != '(') {
          sb.append(st.pop());
        }
        st.pop();
      } else {
        // must be an operator
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
