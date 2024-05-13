
package UDP;

import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) {
        try {
            String serverAddress = "192.168.137.1";
            int serverPort = 5000;
            InetAddress address = InetAddress.getByName(serverAddress);
            DatagramSocket clientSocket = new DatagramSocket();

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Mensaje: ");
                String mensaje = stdIn.readLine();

                if (mensaje.equals("Salir")) {
                    break;
                }

                byte[] sendData = mensaje.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, serverPort);
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Respuesta: " + respuesta);
            }

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}