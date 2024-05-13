package com.mycompany.calculadorarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadorarmi extends Remote {
    double sumar(double a, double b) throws RemoteException;
    double restar(double a, double b) throws RemoteException;
    double multiplicar(double a, double b) throws RemoteException;
    double dividir(double a, double b) throws RemoteException;
}
