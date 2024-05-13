
package com.mycompany.calculadorarmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorCalculadora {
    public static void main(String[] args) {
        try {
            Calculadorarmi calculadora = new CalculadoraImpl();
            LocateRegistry.createRegistry(1099); // Puerto RMI por defecto
            Naming.rebind("Calculadora", calculadora);
            System.out.println("Servidor de calculadora listo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
