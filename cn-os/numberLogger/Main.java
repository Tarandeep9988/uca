import java.util.Scanner;

public class Main {
    public static volatile boolean paused = false;
    public static volatile boolean exit = false;

    public static void main(String[] args) {
        // Logger thread
        Thread logger = new Thread(() -> {
            int cnt = 1;
            while (true) {
                if (exit) {
                    break;
                }
                if (!paused) {
                    System.out.println(cnt++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });
        logger.start();

        // Main thread takes input
        Scanner sc = new Scanner(System.in);
        while (true) {
            String cmd = sc.nextLine();
            if (cmd.equalsIgnoreCase("pause")) paused = true;
            else if (cmd.equalsIgnoreCase("resume")) paused = false;
            else if (cmd.equalsIgnoreCase("exit")) break;
        }

        exit = true;
        System.out.println("Stopped logging.");
    }
}
