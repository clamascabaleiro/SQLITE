package sqlite;


import java.sql.*;

/**
 *
 * @author clamascabaleiro
 */
public class classCreateNewTable {
    public static void newTable(){
      String url = "jdbc:sqlite:alumno.db";
        
        // SQL statement para crear una nueva tabla
        String sql = "CREATE TABLE IF NOT EXISTS dam1 (\n"
                + "	nº integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	nota real\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // Creamos la tabla nueva
            stmt.execute(sql);
            System.out.println("Tabla creada correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo crear la tabla");
        }
}
}

    
