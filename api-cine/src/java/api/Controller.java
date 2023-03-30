/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.action.CinesAction;
import model.action.EntradasAction;
import model.action.PeliculasAction;
import model.action.SalasAction;
import model.dto.Salas;
import utils.ConversorJSON;
import utils.EmailSender;

/**
 * REST Web Service
 *
 * @author S1-PC54
 */
@Path("api")
public class Controller {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    /**
     * Retrieves representation of an instance of api.Controller
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/Peliculas/FINDALL")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws SQLException {
        PeliculasAction pelis = new PeliculasAction();
        return ConversorJSON.objectToJson(pelis.find(context));
        //http://localhost:8080/api-cine/webresources/api/Peliculas/FINDALL?&categoria=drama
        //http://localhost:8080/api-cine/webresources/api/Peliculas/FINDALL?&titulo=silencio
        //http://localhost:8080/api-cine/webresources/api/Peliculas/FINDALL?&limite=a

    }
    
    @GET
    @Path("/Peliculas/cine")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCinePleis() throws SQLException {
        PeliculasAction pelis = new PeliculasAction();
        return ConversorJSON.objectToJson(pelis.findCine(context));
    }

    @GET
    @Path("/Peliculas/GETFICHA")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFichas() throws SQLException {
        //http://localhost:8080/api-cine/webresources/api/Peliculas/GETFICHA?&id=1
        PeliculasAction pelis = new PeliculasAction();
        return ConversorJSON.objectToJson(pelis.getFicha(context));

    }

    @GET
    @Path("/Salas/GETFICHA")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFichaSala() throws SQLException {
        //http://localhost:8080/api-cine/webresources/api/Salas/GETFICHA?&id=1
        SalasAction salas = new SalasAction();
        return ConversorJSON.objectToJson(salas.getFichaSala(context));

    }
    
    @GET
    @Path("/Cines/GETFICHA")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCines() throws SQLException {
        //http://localhost:8080/api-cine/webresources/api/Cines/GETFICHA
        CinesAction cine = new CinesAction();
        return ConversorJSON.objectToJson(cine.getCines());

    }
    
    @GET
    @Path("/Entradas/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String putEntradas() throws SQLException {
        Gson gson = new Gson();
        String salaJSON = context.getQueryParameters().getFirst("salaCorreo");
        String cantidad = context.getQueryParameters().getFirst("cantidad");

        EntradasAction entradas = new EntradasAction();
        entradas.put(context);

        Salas sala = gson.fromJson(salaJSON, Salas.class);
        EmailSender emailSender = new EmailSender("", sala, Integer.parseInt(cantidad));
        emailSender.sendEmail();

        return ConversorJSON.objectToJson("success");
        //http://localhost:8080/api-cine/webresources/api/Entradas/add?&precio=4&idSala=5&cantidad=3

    }

    @GET
    @Path("/Peliculas/rate")
    @Produces(MediaType.APPLICATION_JSON)
    public String ratePelicula() throws SQLException {
         String valoracion = context.getQueryParameters().getFirst("valoracion");
         String idPelicula = context.getQueryParameters().getFirst("idPelicula");
         
         PeliculasAction peliculas = new PeliculasAction();
         peliculas.ratePelicula(valoracion, idPelicula);
         return ConversorJSON.objectToJson("Success");
    }

    /**
     * PUT method for updating or creating an instance of Controller
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
