package Stack;

import java.util.Arrays;

// -> LIFO rule
public class ArrayStack {
    private static int CAPACITY = 10;
    private int top;
    int[] arr;
    public ArrayStack() {
        arr = new int[CAPACITY];
        top = -1;
    }
    public void resize() {
        if (top + 1 == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }
    public void push(int e) {
        if (top + 1 == arr.length) {
            resize();
        }
        arr[top++] = e;
    }
    public int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    int size() {
        return top + 1;
    }
}
