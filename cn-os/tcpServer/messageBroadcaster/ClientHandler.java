package messageBroadcaster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class ClientHandler implements Runnable{
    private Socket client = null;
    private boolean connectionOpen;
    private BlockingQueue<String> messageQueue;
    private PrintWriter out = null;
    
    public ClientHandler(Socket client, BlockingQueue<String> messageQueue) {
        this.client = client;
        connectionOpen = true;
        this.messageQueue = messageQueue;
        try {
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Recieved This from Client : " + line);
                System.out.println("Broadcasting");
                messageQueue.put(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void sendMessage(String message) {
        out.println("Broadcasting: " + message);
    }
    public boolean isConnectionOpen() {
        return connectionOpen;
    }

    public void closeConnection() {
        try {
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
            closeConnection();
        }
    }
}
