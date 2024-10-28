
package com.oregoon.mensajes;
import java.sql.*;

public class Java_Mysql {

    public static void main(String[] args) throws SQLException {
        
       
        consultaBaseDatos();
        
        
        
       
    }
    
    static void consultaBaseDatos() throws SQLException{
         /*
        Conexion a base de datos
        */
        Connection conectar =DriverManager.getConnection(
                "jdbc:mysql://localhost/pruebamensajes_db?serverTimezone=UTC", 
                "root", 
                "Alvaro0801"
        );
        System.out.println("Conexion Exitosa a la base de datos");
        //Hacer un Select a la base de datos
        
        // Se define una cadena SQL para seleccionar todos los registros de la tabla "mensajes"
        String sql = "SELECT * FROM mensajes";
        // Se crea un objeto PreparedStatement utilizando la conexión "conectar" y la consulta SQL definida
        PreparedStatement ps = conectar.prepareStatement(sql);
        // Se ejecuta la consulta y se almacena el resultado en un objeto ResultSet
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("id_mensajes");
            String mensaje = rs.getString("mensaje");
            String autor = rs.getString("autor");
            String fecha = rs.getString("fecha");
            System.out.println("Mensaje: "+ mensaje +" es del autor: "+  autor+" y la fecha: "+ fecha);
        }
         rs.close();
        ps.close();
        conectar.close();
    }
}
