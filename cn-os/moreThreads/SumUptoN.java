public class SumUptoN extends Thread {
    private long n;
    public SumUptoN(long n) {
        this.n = n;
    }
    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i <=n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
