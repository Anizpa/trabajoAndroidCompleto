/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.action;

import java.util.ArrayList;
import model.dao.CinesDAO;
import model.dto.Cine;

/**
 *
 * @author S1-PC54
 */
public class CinesAction {
    
    private CinesDAO dao;

    public CinesAction() {
        dao = new CinesDAO();
    }
    
    public ArrayList<Cine> getCines() {
        String SQL = "SELECT * FROM cine";
        
        return dao.getCines(SQL);
    }
    
    
}
