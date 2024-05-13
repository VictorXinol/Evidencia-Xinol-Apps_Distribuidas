/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import static java.lang.Math. *;

/**
 *
 * @author mcsmo
 */
@WebService(serviceName = "Calculadora_service")
public class Calculadora_service {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public double suma(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a+b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "resta")
    public double resta(@WebParam(name = "c") double c, @WebParam(name = "d") double d) {
        return c-d;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplicacion")
    public double multiplicacion(@WebParam(name = "e") double e, @WebParam(name = "f") double f) {
         return e*f;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "division")
    public double division(@WebParam(name = "g") double g, @WebParam(name = "h") double h) {
        double resultado = 0;
        try
        {
            resultado = g / h;
        } catch (Exception e)
        {

        }
        return resultado;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "potencia")
    public double potencia(@WebParam(name = "i") double i, @WebParam(name = "j") double j) {
        return Math.pow(i, j);
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "raiz")
    public double raiz(@WebParam(name = "k") double k) {
        return Math.sqrt(k);
    }
}
