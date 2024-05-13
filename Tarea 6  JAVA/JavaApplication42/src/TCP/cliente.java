package TCP;

import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) {
        try {
            String serverAddress = "192.168.137.1";
            int serverPort = 50000;

            Socket socket = new Socket(serverAddress, serverPort);
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String line;
            // Código del cliente 

            while (true) {
            
                System.out.print("Cliente: ");
                line = stdIn.readLine();
                
                writer.println(line);
            
                if (line.equals("Salir")) {
                  break;
                }
            
                // Leer respuesta
                line = reader.readLine();
                System.out.println("Respuesta: " + line);
                
              }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}