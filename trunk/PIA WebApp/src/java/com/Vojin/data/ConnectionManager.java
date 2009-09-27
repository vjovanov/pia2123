/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vojin.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Administrator
 */
public class ConnectionManager {
    private static final ConnectionManager INSTANCE = new ConnectionManager();

    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab_rezervacija";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Roces1";

    private ConnectionManager() {
      
    }

    public static final ConnectionManager getInstance() {
        return INSTANCE;
    }

    public Connection create (){
        try{
            Class c = Class.forName("com.mysql.jdbc.Driver");
            c.newInstance();
            return DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
        } catch ( Exception ex){
          throw new RuntimeException("DB connection failure");
        }
    }
    public void connectionClose (Connection conn, PreparedStatement pst, String result){
        try{
            if (conn != null){
                conn.close();
            }
            if (pst != null){
                pst.close();
            }
        } catch (Exception ex){
            result = "error";
        }
    }
}
