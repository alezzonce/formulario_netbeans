package controladores;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:30001/db";
        String usuario = "root";
        String password = "123456";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
        conexion = DriverManager.getConnection(url,usuario,password);
        statement = conexion.createStatement();
        statement.executeUpdate("INSERT INTO USUARIOS(NOMBRE,PASSWORD) VALUES('ABC','ABC123')");
        rs = statement.executeQuery("SELECT * FROM USUARIOS");
        rs.next();
        do {
            System.out.println(rs.getInt("idusuarios")+" : "+rs.getString("nombre"));
        }while(rs.next());
                
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
}





