package sqlite;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author clamascabaleiro
 */
public class MetodosSqLite {
    /**
     * Este método sirve para conectar con la base de datos
     *
     * @return
     */
    public Connection conectar() {
        String url = "jdbc:sqlite:alumno.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        return conn;
    }

    /**
     * Este método crea la tabla en la base de datos. En caso de que ya exista
     * la borra
     */
    public static void newTableDam1() {

        String url = "jdbc:sqlite:alumno.db";

        // SQL statement para crear una nueva tabla
        String sql1 = "DROP TABLE IF EXISTS dam1;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS dam1(\n"
                + "	nº integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	nota real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // Creamos la tabla nueva
            stmt.execute(sql1);
            stmt.execute(sql2);
            System.out.println("Tabla creada correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo crear la tabla");
        }

    }

        public void deleteDam1(int nºalum) {

            String sql = "DELETE FROM dam1 WHERE nº = ?";

            try (Connection conn = this.conectar();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set el parametro correspondiente
                pstmt.setInt(1, nºalum);
                // execute el update delete
                pstmt.executeUpdate();
                System.out.println("Alumno eliminado");

            } catch (SQLException e) {
                System.out.println("No se encuentra el codigo de alumno");
            } finally {

            }
        }

        /**
         * Este método sirve para insertar datos en la tabla dam1
         *
         * @param numeroAlum
         * @param nombreAlum
         * @param notaAlum
         */
        public void insertDam1(int numeroAlum, String nombreAlum, float notaAlum) {
            String sql = "INSERT INTO dam1(nº ,nombre, nota) VALUES(?,?,?)";
            //Insertamos los registros en la tabla
            try (Connection conn = this.conectar();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, numeroAlum);
                pstmt.setString(2, nombreAlum);
                pstmt.setFloat(3, notaAlum);
                pstmt.executeUpdate();
                System.out.println("Insertado");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Registro no insertado no encuentra la tabla");
            }
        }
        
         /**
     * Método para modicar el nombre y nota de la tabla dam1
     * @param numeroAlum
     * @param nombre
     * @param notaAlum 
     */
        
        public void modificarAlumno(int nº,String nombre, float nota) {
        String sql = "UPDATE dam1 SET nombre = ? , "
                + "nota = ? "
                + "WHERE nº = ?";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setFloat(2, nota);
             pstmt.setInt(3, nº);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
            /**
     * Método que devuelve el nº, nombre y nota del alumno
     * @param nºAlumno
     * @return 
     */

    public String devolverAlumno(int nº) {
        String sql = "SELECT nº,nombre,nota"
                + " FROM dam1 WHERE nº=?";
        String resultado = "";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nº);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("nº") + ","
                        + rs.getString("nombre") + ","
                        + rs.getFloat("nota"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
      /**
     * Método para realizar una consulta tanto de id, nombre y telefono médiante un combo box
     * @param campo
     * @param valor
     * @return 
     */

    public ArrayList<String> consultaAlumno(String campo, Object valor) {
        System.out.println("campo = " + campo + " valor = " + valor);
        ArrayList<String> alumnos = new ArrayList<>();
        String sql = "SELECT nº,nombre,nota"
                + " FROM dam1 WHERE " + campo + " = ?";
        try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, valor);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                alumnos.add(rs.getInt("nº") + ","
                        + rs.getString("nombre") + ","
                        + rs.getFloat("nota"));
            }
            return alumnos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return alumnos;
        }
    }


    }


