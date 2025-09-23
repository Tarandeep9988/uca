public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] testCases = {
           "(()())",
           "(()",
           ")()())",
           "",
           "()(())"
        };
        int[] expectedResults = {
            6, 2, 4, 0, 6
        };

        for (int i = 0; i < testCases.length; i++) {
            String testCase = testCases[i];
            int expectedResult = expectedResults[i];
            int actualResult = sol.longestValidParentheses(testCase);
            assert actualResult == expectedResult : "Test failed for " + testCase;
        }

        System.out.println("All test cases passed!");
    }
}