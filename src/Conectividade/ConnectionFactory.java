package Conectividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Melo
 */
public class ConnectionFactory {

    //SQL SERVER
    /*public static Connection connection;
    public static String classDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String URL = "jdbc:sqlserver://21.21.0.201:1433;databaseName=SRV_TESTE;";
    public static String USER = "sa";
    public static String PASS = "135128Lm";*/

    //MYSQL
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/TESTE_MYSQL";
    private static final String USER = "root";
    private static final String PASS = "";

   //CONEXÃO MYSQL
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar: ", ex);
        }
    }

    /*public static Connection getConnection() {

        try {
            Class.forName(classDriver);
            connection = DriverManager.getConnection(URL, USER, PASS);
//          JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!!");
            return connection;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
            return null;
        }

    }*/
    /*private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://mysql785.umbler.com:41890/sabrysystem";
    private static final String USER = "rootsabry";
    private static final String PASS = "5021.RooT";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar: ", ex);
        }
    }*/

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        
        closeConnection (con);
        
        try {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnection (con, stmt);
        
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
