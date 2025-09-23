public class Main {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        assert arrayStack.size() == 3;
        assert arrayStack.peek() == 30;
        assert arrayStack.pop() == 30;
        assert arrayStack.size() == 2;
        arrayStack.push(40);
        arrayStack.push(50); // triggers resize
        assert arrayStack.size() == 4;
        assert !arrayStack.empty();

        LLStack llStack = new LLStack();
        llStack.push(100);
        llStack.push(200);
        llStack.push(300);
        assert llStack.size() == 3;
        assert llStack.peek() == 300;
        assert llStack.pop() == 300;
        assert llStack.size() == 2;
        llStack.push(400);
        assert llStack.size() == 3;
        assert !llStack.empty();

        System.out.println("All assertions passed!");
    }
}

