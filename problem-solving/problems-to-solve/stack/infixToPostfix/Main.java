import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		try (
				Scanner sc1 = new Scanner(new File("input.txt"));
				Scanner sc2 = new Scanner(new File("output.txt"));
			) {
			int t = Integer.valueOf(sc1.nextLine().trim());
			sc1.nextLine();
			
			while (t-- != 0) {
				StringBuilder sb = new StringBuilder();
				while (true) {
					String line = sc1.nextLine().trim();
					if (line.isEmpty()) {
						break;
					}
					sb.append(line);
				}
				String infix = sb.toString();
				if (infix.isEmpty()) {
					// Flush this empty line
					sc1.nextLine();
				}
				
				String expectedOutput = sc2.nextLine().trim();
				// Flush empty line
				sc2.nextLine();
				// System.out.println(infix + " " + expectedOutput);
				assert sol.infixToPostfix(infix).equals(expectedOutput) : infix + " testcase didn't work";
			}
			System.out.println("All test cases passed!");

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
