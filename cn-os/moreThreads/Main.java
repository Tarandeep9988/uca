
public class Main {
    public static void main(String[] args) {
        SumUptoN t1 = new SumUptoN(223);
        SumUptoN t2 = new SumUptoN(234);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
