/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author vicki
 */
@Path("calculadorawsport")
public class CalculadoraWSPort {

    private servidor_client.CalculadoraWS port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculadoraWSPort
     */
    public CalculadoraWSPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method sumar
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("sumar/")
    public String getSumar(@QueryParam("arg0")
            @DefaultValue("0") int arg0, @QueryParam("arg1")
            @DefaultValue("0") int arg1) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.sumar(arg0, arg1);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method restar
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("restar/")
    public String getRestar(@QueryParam("arg0")
            @DefaultValue("0") int arg0, @QueryParam("arg1")
            @DefaultValue("0") int arg1) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.restar(arg0, arg1);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method multiplicar
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("multiplicar/")
    public String getMultiplicar(@QueryParam("arg0")
            @DefaultValue("0") int arg0, @QueryParam("arg1")
            @DefaultValue("0") int arg1) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.multiplicar(arg0, arg1);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method dividir
     * @param arg0 resource URI parameter
     * @param arg1 resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("dividir/")
    public String getDividir(@QueryParam("arg0")
            @DefaultValue("0") int arg0, @QueryParam("arg1")
            @DefaultValue("0") int arg1) {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.dividir(arg0, arg1);
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getContadorPeticiones
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getcontadorpeticiones/")
    public String getContadorPeticiones() {
        try {
            // Call Web Service Operation
            if (port != null) {
                int result = port.getContadorPeticiones();
                return new java.lang.Integer(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private servidor_client.CalculadoraWS getPort() {
        try {
            // Call Web Service Operation
            servidor_client.CalculadoraWSService service = new servidor_client.CalculadoraWSService();
            servidor_client.CalculadoraWS p = service.getCalculadoraWSPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
