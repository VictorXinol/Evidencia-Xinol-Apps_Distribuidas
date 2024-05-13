
package UDP;

import java.io.*;
import java.net.*;

public class server {

  public static void main(String[] args) throws IOException {

    int serverPort = 10000;
    InetAddress ip = InetAddress.getByName("192.168.137.184");

    try (DatagramSocket serverSocket = new DatagramSocket()) {
        serverSocket.bind(new InetSocketAddress(ip, serverPort));

        byte[] buffer = new byte[1024];

        while (true) {
          
          DatagramPacket packetRecibido = new DatagramPacket(buffer, buffer.length);
          serverSocket.receive(packetRecibido);

          String mensaje = new String(packetRecibido.getData(), 0, packetRecibido.getLength());    

          InetAddress clientAddress = packetRecibido.getAddress();
          int clientPort = packetRecibido.getPort();

          System.out.println("Mensaje de " + clientAddress + ":" + clientPort + " -> " + mensaje);
          
          String respuesta = "Respuesta: " + mensaje;
                
          byte[] data = respuesta.getBytes();
          DatagramPacket packetEnviar = new DatagramPacket(data, data.length, clientAddress, clientPort);
          serverSocket.send(packetEnviar);
          
        }
    }

  }

}