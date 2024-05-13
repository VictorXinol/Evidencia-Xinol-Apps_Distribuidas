/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Obtener una referencia al registro RMI
            Registry registry = LocateRegistry.getRegistry("192.168.224.1", 1099);

            // Buscar el objeto remoto en el registro RMI usando su nombre lógico
            Sumador sumador = (Sumador) registry.lookup("Sumador");

            // Invocar el método remoto
            int resultado = sumador.sumar(9, 6);
            System.out.println("Resultado de la suma: " + resultado);
        } catch (Exception e) {
            System.err.println("Excepción en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
