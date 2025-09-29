public class SubSequences {
    /**
     * If S and T are strings, we say that S is a subsequence of T if all
     * letters of S appear in T in the same order (not necessarily consecutively).
     * For example, "ace" is a subsequence of "abcde" while "aec" is not.
     * Given two strings S and T, checks whether S is a subsequence of T.
     * 
     * Constraints:
     * 1. Your solution should be recursive and not use any loops.
     * 2. 0 <= len(S), len(T) <= 1000
     * 3. Strings are case-sensitive and contain only English letters.
     *
     * @param S - The subsequence string.
     * @param T - The target string.
     * @returns boolean - True if S is a subsequence of T, otherwise false.
     **/
     public boolean isSubsequence(String S, String T) {
        return helper(S, T, S.length() - 1, T.length() - 1);
     }
     private boolean helper(String s, String t, int i, int j) {
        if (i < 0) return true; // Able to generate all characters of s
        if (j < 0) return false; // No characters left in t, and still characters left in s
        if (s.charAt(i) == t.charAt(j)) {
            return helper(s, t, i - 1, j - 1);
        }
        // Characters are not matching
        return helper(s, t, i, j - 1); // Skipping character from t;
     }

    /**
     * Main method for testing the SubSequences class.
     */
    public static void main(String[] args) {
        SubSequences subsequences = new SubSequences();
        assert subsequences.isSubsequence("ace", "abcde") == true : "Test case 1 failed";
        assert subsequences.isSubsequence("aec", "abcde") == false : "Test case 2 failed";
        assert subsequences.isSubsequence("", "abcde") == true : "Test case 3 failed";
        assert subsequences.isSubsequence("abc", "") == false : "Test case 4 failed";
        assert subsequences.isSubsequence("abc", "ahbgdc") == true : "Test case 5 failed";
        assert subsequences.isSubsequence("axc", "ahbgdc") == false : "Test case 6 failed";
    }
}