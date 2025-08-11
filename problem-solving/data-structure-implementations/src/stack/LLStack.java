// Lifo order
public class LLStack {
	
	private class Node {
		int val;
		Node next;
		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		Node(int val) {
			this(val, null);
		}
	}

	private Node top;
	private int size;
	
	// Default Constructor
	// No need to give capacity
	public LLStack() {
		top = null;
		size = 0;
	}

	// push -> Add element to top
	public void push(int ele) {
		top = new Node(ele, top);
		size++;
	}

	// pop -> Remove and return top element
	public int pop() {
		if (empty()) {
			return -1;
		}
		int ele = top.val;
		top = top.next;
		size--;
		return ele;
	}
	
	// peek -> Returns top element without removing
	public int peek() {
		if (empty()) {
			return -1;
		}
		return top.val;
	}

	// empty -> check if stack is empty
	public boolean empty() {
		return top == null;
	}

	// size -> returns size of stack
	public int size() {
		return size;
	}
}

