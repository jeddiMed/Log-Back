/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamed
 */
public class DataSource {
    
    private static DataSource instance;
    private String url="jdbc:mysql://localhost:3306/kids";
    private String login="root";
    private String password="";
    private Connection conn;
    
    private DataSource(){
        
        try {
            conn=DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }
    
}
