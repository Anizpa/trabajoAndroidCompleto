/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.Entradas;
import motor.IMotor;
import motor.MySQLMotor;

/**
 *
 * @author S1-PC54
 */
public class EntradasDAO {

    private IMotor motor;

    public EntradasDAO() {
        this.motor = new MySQLMotor();
    }

    public ArrayList<Entradas> find(String SQL) throws SQLException {
        motor.conectar();
        ResultSet result = motor.consultar(SQL);
        ArrayList<Entradas> listaEntradas = new ArrayList();
        while (result.next()) {
            Entradas entrada = new Entradas();
            entrada.setIdEntrada(result.getInt(1));
            entrada.setPrecio(result.getDouble(2));
            entrada.setIdSala(result.getInt(3));

            listaEntradas.add(entrada);
        }

        return listaEntradas;
    }

    public void add(String SQL) throws SQLException {
        motor.conectar();
        motor.ejecutar(SQL);
        motor.desconectar();
    }

    public void update(String SQL) throws SQLException {
        motor.conectar();
        motor.ejecutar(SQL);
        motor.desconectar();
    }
}
