import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDPClient will send data to server
 */

public class UDPClient {
  public static void main(String[] args) {
    String serverHost = "localhost";
    int serverPort = 9283;

    try (DatagramSocket clientSocket = new DatagramSocket();
        Scanner sc = new Scanner(System.in)) {

      InetAddress serverAddress = InetAddress.getByName(serverHost);

      while (true) {
        System.out.println("Enter message: ");
        String msg = sc.nextLine();

        byte[] sendData = msg.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);

        // Receive echo
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Echo from server: " + response);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
