/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.UriInfo;
import model.dao.EntradasDAO;
import model.dto.Entradas;

/**
 *
 * @author S1-PC54
 */
public class EntradasAction {

    private EntradasDAO dao;

    public EntradasAction() {
        this.dao = new EntradasDAO();
    }

    public ArrayList<Entradas> find(UriInfo context) throws SQLException {
        String SQL = "SELECT * FROM entrada WHERE 1=1";
        String idEntrada = context.getQueryParameters().getFirst("idEntrada");
        //String horario = context.getQueryParameters().getFirst("horario");
        String precio = context.getQueryParameters().getFirst("precio");
        String idSala = context.getQueryParameters().getFirst("idSala");

        if (idEntrada != null) {
            SQL += " AND IDENTRADA \"" + idEntrada + "\"";

        }
        /*if (horario != null) {
            SQL += " AND HORARIO =\"" + horario + "\"";
        }*/

        if (precio != null) {
            SQL += "  AND PRECIO =\"" + precio + "\"";

        }
        if (idSala != null) {
            SQL += "  AND IDSALA \"" + idSala + "\"";

        }

        return dao.find(SQL);
    }

    public void put(UriInfo context) throws SQLException {
        //String precio = context.getQueryParameters().getFirst("precio");
        String idSala = context.getQueryParameters().getFirst("idSala");
        String cantidad = context.getQueryParameters().getFirst("cantidad");
        System.out.println(idSala + " " + cantidad);

        int numCantidad = Integer.parseInt(cantidad);

        String SQL = "";
        for (int i = 0; i < numCantidad; i++) {
            SQL = "INSERT INTO entrada(precio, idSala) VALUES (4," + idSala + ")";
            System.out.println(SQL);
            dao.add(SQL);
        }

        SQL = "UPDATE sala SET butacasLibres = butacasLibres - " + cantidad + ", butacasOcupadas = butacasOcupadas + " + cantidad + " WHERE idSala = " + idSala;
        
        dao.update(SQL);

    }

}
