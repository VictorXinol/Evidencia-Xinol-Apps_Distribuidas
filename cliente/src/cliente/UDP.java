/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDP {

    public static void main(String args[]) throws Exception {
    
        Scanner scanner = new Scanner(System.in); 

        DatagramSocket socket = new DatagramSocket();
        InetAddress host = InetAddress.getByName("192.168.137.1");
        int port = 65432;

        System.out.println("Estas conectado");
        while(true) {

            String mensaje = scanner.nextLine();
            byte[] send = mensaje.getBytes(); 

            DatagramPacket request = 
                    new DatagramPacket(send, send.length, host, port);
            
            socket.send(request);
            
            byte[] buffer = new byte[1024];
            DatagramPacket response = 
                    new DatagramPacket(buffer, buffer.length); 

            socket.receive(response);

            String text = new String(buffer, 0, response.getLength());     
            System.out.println("Respuesta del servidor: " + text);
        }
   } 
}