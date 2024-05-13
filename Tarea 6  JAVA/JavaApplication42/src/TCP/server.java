package TCP;

import java.io.*;
import java.net.*;

public class server {
 
    public static void main(String[] args) {

        try {
            
            int serverPort = 7777;
            InetAddress ip = InetAddress.getByName("192.168.137.184");
            
            try (ServerSocket serverSocket = new ServerSocket(serverPort, 50, ip)) {
                serverSocket.setSoTimeout(10000);
                
                System.out.println("Servidor esperando en " + ip.getHostAddress() + ":" + serverPort);
                
                while(true) {
                    Socket clientSocket = serverSocket.accept();     
                    System.out.println("Cliente conectado");
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                                    
                    String input;
                    while ((input = in.readLine()) != null) {
                        System.out.println(input);
                        out.println("Respuesta: " + input);
                    }
                    
                    System.out.println("Cliente desconectado");
                    clientSocket.close();
                }
            }

        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout desocket");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}