public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testCases = {
            {2, 1, 5, 6, 2, 3},
            {2, 4},
            {1, 3, 1}, 
            {1, 2, 1},
            {5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5},
            {2, 1, 2}
        };
        int[] expectedResults = {
            10, 4, 3, 3, 9, 9, 3
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int expectedResult = expectedResults[i];
            int actualResult = sol.largestRectangleArea(testCase);
            assert actualResult == expectedResult;
        }

        System.out.println("All test cases passed!");
    }
}