/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S1-PC54
 */
public class MySQLMotor implements IMotor{
    private final Logger LOGGER = Logger.getLogger(MySQLMotor.class.getName());

    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL
            = "jdbc:mysql://localhost:3306/androidcine?"
            + "useUnicode=true&"
            + "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;



    @Override
    public void conectar() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.
                    getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    public int ejecutar(String sql) {
       int affectedRows = 0;
        try {
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return affectedRows;
    }
    
        @Override
    public ResultSet consultar(String sqlQuery) {
        try {

            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return resultSet;
    }

    @Override
    public void desconectar() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

  
}
