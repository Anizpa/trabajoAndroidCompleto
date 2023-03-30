/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.action;

import java.sql.SQLException;
import javax.ws.rs.core.UriInfo;
import model.dao.SalasDAO;
import model.dto.Salas;

/**
 *
 * @author S1-PC54
 */
public class SalasAction {

    private SalasDAO dao;

    public SalasAction() {
        this.dao = new SalasDAO();
    }

    public Salas getFichaSala(UriInfo context) throws SQLException {
        String id = context.getQueryParameters().getFirst("id");
        String SQL = "SELECT s.idSala, s.butacasLibres, s.horario, c.nombre, p.titulo FROM sala s "
                + " INNER JOIN cine c ON c.idCine = s.idCine"
                + " INNER JOIN pelicula p ON p.idPelicula = s.idPelicula WHERE s.idSala = " + id;
        
        return dao.getSala(SQL);
    }
}
