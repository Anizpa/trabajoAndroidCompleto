/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.action;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.UriInfo;
import model.dao.PeliculasDAO;
import model.dto.Peliculas;
import model.dto.PeliculasFicha;
import utils.ConversorJSON;

/**
 *
 * @author S1-PC54
 */
public class PeliculasAction {

    private PeliculasDAO dao;

    public PeliculasAction() {
        this.dao = new PeliculasDAO();
    }

    public ArrayList<Peliculas> find(UriInfo context) throws SQLException {
        String SQL = "SELECT * FROM pelicula WHERE 1=1";
        String titulo = context.getQueryParameters().getFirst("titulo");
        //String sinopsis = context.getQueryParameters().getFirst("sinopsis");
        String categoria = context.getQueryParameters().getFirst("categoria");
        //String trailer = context.getQueryParameters().getFirst("trailer");
        String edadRecomendada = context.getQueryParameters().getFirst("edadRecomendada");
        String valoracion = context.getQueryParameters().getFirst("valoracion");
        String imagen = context.getQueryParameters().getFirst("imagen");

        String limite = context.getQueryParameters().getFirst("limite");

        String id = context.getQueryParameters().getFirst("id");
        System.out.println(valoracion + " " + id + " " + limite);
        if (titulo != null) {
            SQL += " AND TITULO LIKE \"%" + titulo + "%\"";

        }
        if (categoria != null) {
            SQL += " AND CATEGORIA =\"" + categoria + "\"";
        }

        if (edadRecomendada != null && !"0".equals(edadRecomendada)) {
            SQL += "  AND EDADRECOMENDADA =\"" + edadRecomendada + "\"";

        }
        if (valoracion != null && !"0.0".equals(valoracion)) {
            SQL += "  AND VALORACION >\"" + valoracion + "\" AND VALORACION < \"" + (Double.parseDouble(valoracion) + 1) + "\"";

        }
        if (id != null && !"0".equals(id)) {
            SQL += " AND  IDPELICULA=\"" + id + "\"";

        }
        if (limite != null && !"100".equals(limite)) {
            SQL += " ORDER BY VALORACION DESC LIMIT 10";

        }

        if (imagen != null) {
            SQL += " AND IMAGEN=\"" + imagen + "\"";

        }

        return dao.find(SQL);
    }

    public PeliculasFicha getFicha(UriInfo context) throws SQLException {
        String id = context.getQueryParameters().getFirst("id");
        String SQL = "SELECT idPelicula, titulo, sinopsis, categoria, trailer, "
                + "edadRecomendada, valoracion, duracion, imagen FROM pelicula "
                + "WHERE idPelicula=" + id;

        PeliculasFicha ficha = dao.getPeliculaInfo(SQL);
        SQL = "SELECT s.idSala, s.horario, s.butacasLibres, c.nombre from sala s "
                + "INNER JOIN cine c ON c.idCine = s.idCine "
                + "WHERE s.idPelicula = " + id;
        
        
        ficha.setSalas(dao.getSalaPeliculas(SQL));
        return ficha;
    }
    
    public void ratePelicula(String valoracion, String idPelicula) {
        String SQL = "UPDATE pelicula SET valoracion = (valoracion * vecesValorada + " + valoracion + ") / (vecesValorada+1), vecesValorada = vecesValorada + 1"
                + " WHERE idPelicula = " + idPelicula;
        
        System.out.println(SQL);
        dao.updateRate(SQL);
        
    }
    
    public ArrayList<Peliculas> findCine(UriInfo context) throws SQLException {
        String idSala = context.getQueryParameters().getFirst("idCine");
        String SQL = "SELECT p.idPelicula, p.titulo, p.sinopsis, p.categoria, p.trailer, p.edadRecomendada, p.visualizaciones, p.valoracion, p.vecesValorada, p.duracion, p.imagen FROM pelicula p "
                + "INNER JOIN sala s ON s.idPelicula = p.idPelicula "
                + "INNER JOIN cine c ON c.idCine = s.idCine WHERE c.idCine = " + idSala;
        return dao.find(SQL);
    }
    
}
