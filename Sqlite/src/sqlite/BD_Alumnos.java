
package sqlite;

import javax.swing.JOptionPane;
import static sqlite.classConnect.connect;
import static sqlite.classCreateNewTable.newTable;
import sqlite.classInsertTable.InsertApp;

/**
 *
 * @author clamascabaleiro
 */
public class BD_Alumnos {
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
        newTable();
        InsertApp ins=new InsertApp();
        ins.connect();
        int numero =Integer.parseInt(JOptionPane.showInputDialog(null,"Numero del alumno : "));
        String nombre =JOptionPane.showInputDialog(null,"Nombre del alumno : ");
        float nota = Float.parseFloat(JOptionPane.showInputDialog(null,"Nota : "));
        ins.insert(numero, nombre, nota);
    }
       
    }
