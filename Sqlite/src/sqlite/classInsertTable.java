package sqlite;

import java.sql.*;

/**
 *
 * @author clamascabaleiro
 */
public class classInsertTable {
    public static class InsertApp {
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:alumno.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
        
    public void insert(int numero, String nombre, float nota) {
        String sql = "INSERT INTO dam1(nº ,nombre, nota) VALUES(?,?,?)";
        //Insertamos los registros en la tabla
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numero);
            pstmt.setString(2, nombre);
            pstmt.setFloat(3,nota);
            pstmt.executeUpdate();
            System.out.println("Insertado");
        } catch (SQLException e) {
            System.out.println("Registro no insertado no encuentra la tabla");
        }
    }
 
}
}
