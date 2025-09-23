package messageBroadcaster;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BroadcastServer {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("We are able to create the obj for the ServerSocket on the port " + port);
        } catch (Exception e) {
            System.err.println("We are not able to create the obj for the ServerSocket on the port " + port);
            return ;
        }

        BlockingQueue<String> bq = new LinkedBlockingQueue<>();
        List<ClientHandler> clientList = new ArrayList<>();

        try {
            Broadcaster broadcaster = new Broadcaster(bq, clientList);
            new Thread(broadcaster).start();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Client Address is: " + client.getRemoteSocketAddress());
                ClientHandler c = new ClientHandler(client, bq);

                Thread t = new Thread(c);
                clientList.add(c);
                t.start();
            } catch (Exception e) {
                System.err.println("Getting Error while accepting the connection.");
            }
        }
    }   

}
