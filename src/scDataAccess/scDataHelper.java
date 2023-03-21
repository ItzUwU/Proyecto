package scDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public abstract class scDataHelper {

    private static Connection scConexion = null;

    /**
     * Método ESTÁTICO que realiza la conexión con la base de datos MYSQL
     * 
     * @return retorna un objeto de tipo CONNECTION
     */

    public static Connection scGetConexion() {
        try {
            scConexion = DriverManager.getConnection("jdbc:mysql://localhost/scdb_proyecto", "root", "");
            return scConexion;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión en: scGetConexion()" + e.getMessage());
        }
        return null;
    }

    /***
     * Método ESTÁTICO que realiza una petición a la base de datos
     * 
     * @param sql Es la petición a la base de datos
     * @return retorna la respuesta de la base de datos, objeto de RESULSET
     * @throws AppException
     */

    protected static ResultSet scGetResultSet(String sql) {
        Connection scConn = null; 
        Statement scStmt = null;
        ResultSet scRs = null;

        try {
            scConn = scGetConexion();
            scStmt = scConn.createStatement(); 
            scRs = scStmt.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener respuesta en : scGetResultSet(String sql) " + e.getMessage());
        }
        return scRs;
    }

    /**
     * Permite cerrar la conexión con la Base de Datos
     * @throws SQLException
     */

    public static void scCerrarConexion() throws SQLException{
        try{
            scConexion.close();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e);
            scConexion.close();
        }finally{
            scConexion.close();
        }
    }
}
