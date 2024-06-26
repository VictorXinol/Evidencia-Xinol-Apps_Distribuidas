import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Esperando conexiones...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println("Cliente dice: " + inputLine);
            }

            clientSocket.close();
        }
    }
}
