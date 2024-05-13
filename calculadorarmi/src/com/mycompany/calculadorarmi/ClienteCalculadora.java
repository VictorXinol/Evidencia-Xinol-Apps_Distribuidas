
package com.mycompany.calculadorarmi;

import java.rmi.Naming;

public class ClienteCalculadora {
    public static void main(String[] args) {
        try {
            Calculadorarmi calculadora = (Calculadorarmi) Naming.lookup("rmi://192.168.228.240/Calculadora");
            double resultado = calculadora.restar(5, 10);
            System.out.println("Resultado de la operacion: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}