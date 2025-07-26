
import java.util.Stack;
class MinStack
{
    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new Pair(val, val));
        }
        else {
            st.push(new Pair(val, Math.min(this.getMin(), val)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().a;
    }
    
    public int getMin() {
        return st.peek().b;
    }
    
	public static void main (String[] args) {

	}
}
