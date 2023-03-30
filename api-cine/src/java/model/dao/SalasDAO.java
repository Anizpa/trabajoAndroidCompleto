/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.dto.Salas;
import motor.IMotor;
import motor.MySQLMotor;

/**
 *
 * @author S1-PC54
 */
public class SalasDAO {

    private IMotor motor;

    public SalasDAO() {
        this.motor = new MySQLMotor();
    }

    public Salas getSala(String SQL) throws SQLException {
        motor.conectar();
        ResultSet result = motor.consultar(SQL);
        Salas sala = new Salas();

        while (result.next()) {
            sala.setIdSala(result.getInt(1));
            sala.setButacas(result.getInt(2));
            sala.setHorario(result.getString(3));
            sala.setNombreCine(result.getString(4));
            sala.setTitulo(result.getString(5));

        }
        return sala;

    }

}
