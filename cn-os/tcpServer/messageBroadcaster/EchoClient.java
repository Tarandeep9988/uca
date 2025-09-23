package messageBroadcaster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.server.ExportException;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        String hostServer = "localhost";
        int serverPort = 12345;
        try (
            Socket socket = new Socket(hostServer, serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
        ) {
            System.out.println("Client Connection is made with the server");
            String msg;
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                Thread.sleep(100);
                System.out.println("Enter the line: ");
                msg = sc.nextLine();
                if ("exit".equalsIgnoreCase(msg)) break;
                out.println(msg);
                // System.out.println("Broadcast message: " + in.readLine());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}