package sqlite;

import java.sql.*;

/**
 *
 * @author clamascabaleiro
 */
public class Mostrar {
  public static Connection getConnection(){
        Connection cn=null;
        try {
            cn=DriverManager.getConnection("jdbc:sqlite:alumno.db");
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return cn;
    }
    
    
    public static ResultSet getTabla(String consulta) throws SQLException {
        Connection cn=getConnection();
        Statement st;
        ResultSet datos=null;
        try{
            st=cn.createStatement();
            datos=st.executeQuery(consulta);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    return datos;
    }
}
