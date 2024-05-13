
import servidor.*;

import javax.xml.ws.Endpoint;

public class LanzadorServicio {

    public final static String urlCalculadoraWS = "http://192.168.227.83:8888/calculadora";

    public static void main(String[] args) {
        Endpoint.publish(urlCalculadoraWS, new CalculadoraWS());
        System.out.println("Servicio Web en espera en "+urlCalculadoraWS);        
    }
}
