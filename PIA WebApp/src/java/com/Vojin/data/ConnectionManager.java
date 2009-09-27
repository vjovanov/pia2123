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

    public ConnectionManager() {
    }
    public void connectionInitialisation (Connection conn, Class c, String result){
        try{
            c = Class.forName("com.mysql.jdbc.Driver");
            c.newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_rezervacija","root","jebaga");
        } catch ( Exception ex){
          result = "error";
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
