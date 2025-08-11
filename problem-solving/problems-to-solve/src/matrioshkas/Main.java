import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int j = 1;
        try (
            Scanner sc1 = new Scanner(new File("input.txt"));
            Scanner sc2 = new Scanner(new File("output.txt"))
        ) {
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                String inputLine = sc1.nextLine().trim();
                int[] testCase;
                if (inputLine.isEmpty()) {
                    testCase = new int[]{};
                }
                else {
                    String[] arr = inputLine.split("\\s+");
                    testCase = new int[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        testCase[i] = Integer.valueOf(arr[i]);
                    }
                }
                String expectedOutput = sc2.nextLine().trim();
                String result = sol.isMatrioshka(testCase) ? ":-) Matrioshka!" : ":-( Try again.";
                assert result.equals(expectedOutput) : inputLine + " didn't matched! " + j;
                j++;
            }

            System.out.println("All test cases passed!");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
