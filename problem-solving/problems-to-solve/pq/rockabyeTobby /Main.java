import java.io.File;
import java.util.Scanner;
/**
 * Main class to test the RockabyeTobby algorithm using input and output files.
 * Reads test cases from "input.txt" and expected results from "output.txt".
 * For each test case, it calls {@link RockabyeTobby#rockabyeTobby(String[], int[], int)}
 * and asserts that the returned output matches the expected output.
 * Prints "All test cases passed!" if all assertions succeed, or throws an
 * AssertionError/Exception otherwise.
 */


public class Main {

  /**
 * Entry point to run test cases for the RockabyeTobby algorithm.
 * Reads input from "input.txt" and expected output from "output.txt",
 * then asserts that the computed results match the expected results.
 */
  public static void main(String[] args) {

    try (
        Scanner sc1 = new Scanner(new File("input.txt"));
        Scanner sc2 = new Scanner(new File("output.txt"));) {
      int t = sc1.nextInt();
      while (t-- != 0) {
        int n = sc1.nextInt();
        int k = sc1.nextInt();
        String[] medications = new String[n];
        int[] frequencys = new int[n];
        for (int i = 0; i < n; i++) {
          medications[i] = sc1.next();
          frequencys[i] = sc1.nextInt();
        }
        String[] output = RockabyeTobby.rockabyeTobby(medications, frequencys, k);
        for (int i = 0; i < k; i++) {
          assert output[i].equals(sc2.nextLine().trim()) : "Test case failed";
        }
      }
      System.out.println("All test cases passed!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
