package sqlite;

import java.sql.*;

/**
 *
 * @author clamascabaleiro
 */
public class classConnect {
    
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:alumno.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexion establecida con exito");
            
            
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la base de datos");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("La base de datos no existe");
            }
        }
    }
}
