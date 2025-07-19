public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(() -> {
            System.out.println("I am inside thread");
        });
        main.start();
    }
}