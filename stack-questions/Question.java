import java.util.Scanner;
import java.util.Stack;

class Question {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str_arr = str.split(" ");
        int n = str_arr.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(str_arr[i]);
        }

        if (isMatrioshka(arr)) {
            System.out.println(":-) Matrioshka !");
        }
        else {
            System.out.println(":-( Try again.");
        }
        sc.close();
    }
    public static boolean isMatrioshka(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int ele : arr) {
            if (st.isEmpty()) {
                st.push(ele);
            }
            if (Math.abs(ele) > Math.abs(st.peek())) {
                return false;
            }
            if (Math.abs(ele) == Math.abs(st.peek())) {
                st.pop();
            }
            else{
                st.push(ele);
            }
        }
        return st.isEmpty();
    }
}