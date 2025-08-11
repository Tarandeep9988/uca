import java.util.Arrays;

// Lifo order
public class ArrayStack {
	private static int DEFAULT_CAPACITY = 10;
	private int capacity, top;
	private int[] arr;
	
	// Parameterized Constructor
	// When CAPACITY given
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		top = -1;
	}

	// Default Constructor
	// When CAPACITY not given
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	// push -> Add element to top
	public void push(int ele) {
		if (top + 1 == capacity) {
			resize(2 * capacity);
		}    
		arr[++top] = ele;
	}

	// pop -> Remove and return top element
	public int pop() {
		if (empty()) {
			return -1;
		}
		int ele = arr[top];
		top--;
		if (size() <= capacity / 2) {
			resize(3 * capacity / 4);
		}
		return ele;
	}
	
	// peek -> Returns top element without removing
	public int peek() {
		if (empty()) {
			return -1;
		}
		return arr[top];
	}

	// empty -> check if stack is empty
	public boolean empty() {
		return top == -1;
	}
	
	// size -> returns size
	public int size() {
		return top + 1;
	}

	// resize -> utility function to resize array
	public void resize(int new_capa) {
		arr = Arrays.copyOf(arr, new_capa);
		capacity = new_capa;
	}
}
