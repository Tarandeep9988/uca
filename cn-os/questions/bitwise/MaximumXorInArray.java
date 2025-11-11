/**
 * Finds the maximum XOR of any two elements in the array.
 * Key constraints: The array contains at least two non-negative integers.
 * @param nums an array of non-negative integers
 * @return the maximum XOR value of any two distinct elements in the array
 */
public class MaximumXorInArray {

    public static int findMaximumXor(int[] nums) {
        // method stub
        int xor = 0;
        for (int e : nums) {
            xor = Math.max(xor ,xor ^ e);
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println("Expected 126: " + findMaximumXor(new int[]{26, 100, 25, 13, 4, 14}));
        System.out.println("Expected 7: " + findMaximumXor(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println("Expected 0: " + findMaximumXor(new int[]{0, 0, 0}));
    }
}

