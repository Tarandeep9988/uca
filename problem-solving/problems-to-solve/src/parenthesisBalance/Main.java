import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        try (
            Scanner sc1 = new Scanner(new File("input.txt"));
            Scanner sc2 = new Scanner(new File("output.txt"))
        ) {
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                String testCase = sc1.nextLine().trim();
                String expectedOutput = sc2.nextLine().trim();
                String result = sol.parenthesisBalance(testCase) ? "Yes" : "No";
                assert result.equals(expectedOutput) : testCase + " didn't matched! " + expectedOutput + " " + result;
            }

            System.out.println("All test cases passed!");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
