/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Cine;
import motor.IMotor;
import motor.MySQLMotor;

/**
 *
 * @author S1-PC54
 */
public class CinesDAO {
    
    private IMotor motor;

    public CinesDAO() {
        this.motor = new MySQLMotor();
    }
    
    public ArrayList<Cine> getCines(String SQL) {
        motor.conectar();
        ResultSet result = motor.consultar(SQL);
        ArrayList<Cine> cines = new ArrayList<>();
        
        try {
            while (result.next()) {
                Cine cine = new Cine();
                cine.setIdCine(result.getInt(1));
                cine.setNombre(result.getString(2));
                cine.setDireccion(result.getString(3));
                cine.setCapacidad(result.getInt(4));
                cines.add(cine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cines;
    }
}
