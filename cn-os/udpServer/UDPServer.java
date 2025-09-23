import java.net.*;

/**
 * UDP client-server program
 * 
 * <p> UDP uses DatagramSocket and DatagramPacket
 * Server needs
 * A socket bound to a port.
 * To receive packets.
 * To send back (echo) the same data.
 * 
 * Client needs:
 * A socket (no need to bind)
 * To send packet to server
 * To wait for response
 */

public class UDPServer {
  public static void main(String[] args) {
    int port = 9283; // Server port

    try (DatagramSocket serverSocket = new DatagramSocket(port)) {
      byte[] receiveData = new byte[1024];
      byte[] sendData;

      System.out.println("UDP Server is running on port: " + port);

      while (true) {
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);

        String clientMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from client: " + clientMsg);

        // Prepare reponse (echo back)
        sendData = clientMsg.getBytes();
        InetAddress clientIP = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);
        serverSocket.send(sendPacket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
