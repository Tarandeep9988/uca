public class MyThread extends Thread{
    @Override
    public void run() {
        // System.out.println("Thread running: " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId() + " From t3");
    }
}
