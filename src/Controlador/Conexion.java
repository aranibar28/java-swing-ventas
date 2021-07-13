package Controlador;
import java.sql.*;
import javax.swing.*;

public class Conexion {
Connection conect = null;
   public Connection getConexion()
    {
      try {
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/tienda","root",""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
}}
