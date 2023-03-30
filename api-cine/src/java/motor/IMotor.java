/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import java.sql.ResultSet;

/**
 *
 * @author S1-PC54
 */
public interface IMotor {
    public void conectar();
    public int ejecutar(String sql);
    public ResultSet consultar(String sql);
    public void desconectar();
}
