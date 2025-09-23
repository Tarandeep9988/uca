package messageBroadcaster;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Broadcaster implements Runnable{
    BlockingQueue<String> messageQueue;
    List<ClientHandler> list;
    
    public Broadcaster(BlockingQueue<String> messageQueue, List<ClientHandler> list) {
        this.messageQueue = messageQueue;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messageQueue.take();   
                for (ClientHandler client : list) {
                    if (client.isConnectionOpen()) {
                        client.sendMessage(message);
                    }
                }
            } catch (InterruptedException e) {
                // Exiting
                break;
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
