import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        });
        MyRunnable task = new MyRunnable();
        Thread t2 = new Thread(task);
        System.out.println("Thread running: " + Thread.currentThread().getName());
        System.out.println(Thread.NORM_PRIORITY);
        
        
        Thread t3 = new MyThread();
        t1.start();
        t2.start();
        // t3.start();
        t3.run();
        System.out.println();
    }
}
