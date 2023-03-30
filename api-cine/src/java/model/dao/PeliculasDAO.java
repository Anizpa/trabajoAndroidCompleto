/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Peliculas;
import model.dto.PeliculasFicha;
import model.dto.Salas;
import motor.IMotor;
import motor.MySQLMotor;

/**
 *
 * @author S1-PC54
 */
public class PeliculasDAO implements IDAO<Peliculas, Integer> {

    private final String FINDALL
            = "SELECT * FROM `pelicula` WHERE 1=1 ";

    private final String ADD
            = "INSERT INTO `pelicula` (`titulo`, `sinopsis`, `categoria`, `trailer`, `edadRecomendada`, "
            + "`visualizaciones`, `valoracion`, `vecesValorada`, `duracion`) VALUES ?,?,?,?,?,?,?,?,?";

    private final String DELETE = "DELETE FROM `pelicula` WHERE ID_Pelicula=";

    private final String UPDATE = "UPDATE `pelicula` SET ";
    //Si te bloqueas me dices :D

    private IMotor motor;

    public PeliculasDAO() {
        this.motor = new MySQLMotor();
    }

    @Override
    public int add(Peliculas bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Peliculas> findAll(Peliculas bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Peliculas bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Peliculas> find(String SQL) throws SQLException {
        motor.conectar();
        ResultSet result = motor.consultar(SQL);
        ArrayList<Peliculas> listaPeliculas = new ArrayList();
        while (result.next()) {
            Peliculas pelicula = new Peliculas();
            pelicula.setIdPelicula(result.getInt(1));
            pelicula.setTitulo(result.getString(2));
            pelicula.setSinopsis(result.getString(3));
            pelicula.setCategoria(result.getString(4));
            pelicula.setTrailer(result.getString(5));
            pelicula.setEdadRecomendada(result.getInt(6));
            pelicula.setVisualizaciones(result.getInt(7));
            pelicula.setValoracion(result.getDouble(8));
            pelicula.setVecesValorada(result.getInt(9));
            pelicula.setDuracion(result.getInt(10));
            pelicula.setImagen(result.getString(11));
            listaPeliculas.add(pelicula);
        }

        return listaPeliculas;
    }

    public PeliculasFicha getPeliculaInfo(String SQL) throws SQLException {
        motor.conectar();
        ResultSet result = motor.consultar(SQL);
        PeliculasFicha ficha = new PeliculasFicha();
        while (result.next()) {
            ficha.setIdPelicula(result.getInt(1));
            ficha.setTitulo(result.getString(2));
            ficha.setSinopsis(result.getString(3));
            ficha.setCategoria(result.getString(4));
            ficha.setTrailer(result.getString(5));
            ficha.setEdadRecomendada(result.getInt(6));
            ficha.setValoracion(result.getDouble(7));
            ficha.setDuracion(result.getInt(8));
            ficha.setImagen(result.getString(9));

        }

        return ficha;

    }

    public ArrayList<Salas> getSalaPeliculas(String SQL) throws SQLException {
        motor.conectar();
        ResultSet result = motor.consultar(SQL);
        ArrayList<Salas> listaSalas = new ArrayList();
        while (result.next()) {
            Salas sala = new Salas();
            sala.setIdSala(result.getInt(1));
            sala.setHorario(result.getString(2));
            sala.setButacas(result.getInt(3));
            sala.setNombreCine(result.getString(4));
            
            listaSalas.add(sala);
        }

        return listaSalas;
    }
    
    public void updateRate(String SQL) {
        motor.conectar();
        motor.ejecutar(SQL);
        motor.desconectar();
    }

}
