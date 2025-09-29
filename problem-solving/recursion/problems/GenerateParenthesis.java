import java.util.*;

public class GenerateParenthesis {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * Constraints:
     * 1. 1 <= n <= 8
     * 2. The solution set must not contain duplicate combinations.
     * 
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * 
     * @param n - Number of pairs of parentheses.
     * @returns List<String> - A list of all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(2 * n);
        helper(result, sb, n, n);
        return result;
    }
    private void helper(List<String> result, StringBuilder sb, int open, int close) {
        // base case -> when open and close parentheses are used
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }
        if (open > close || close < 0 || open < 0) {
            return;
        }
        if (open > 0) {
            sb.append('(');
            helper(result, sb, open - 1, close);
            sb.setLength(sb.length() - 1);
        }
        if (close > open) {
            sb.append(')');
            helper(result, sb, open, close - 1);
            sb.setLength(sb.length() - 1);
        }
    }

    /**
     * Main method for testing the GenerateParenthesis class.
     */
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 3;
        List<String> result = gp.generateParenthesis(n);
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assert result.size() == expected.size() && result.containsAll(expected) : "Test case failed";
    }
}