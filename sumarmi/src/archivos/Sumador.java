/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sumador extends Remote {
    public int sumar(int a, int b) throws RemoteException;
}
