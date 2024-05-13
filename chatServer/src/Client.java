import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        //Socket socket = new Socket("192.168.137.1", 20000);
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Conectado al servidor");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Conectado");

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println(" " + in.readLine());
        }

        socket.close();
    }
}