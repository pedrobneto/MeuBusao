/*
 * Referência: <a href="https://github.com/descompila/MercadinhoGosling/blob/master/src/connection/ConnectionFactory.java">ConnectionFactory</a>
 */
package meubusao.connection;

import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Samuelson
 */
public class ConnectionFactory {

    /**
     * URL do BD.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/meubusao";
    
    /**
     * Usuário utilizado para se conectar ao BD.
     */
    private static final String USER = "root";
    
    /**
     * Senha utilizada para se conectar ao BD.
     */
    private static final String PASS = "aluno";

    /**
     * Tenta criar uma conexão com o BD da URL.
     * @return conexão válida para o BD.
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar se conectar: ", e);
        }
    }

    /**
     * Fecha uma conexão para o BD.
     * @param con conexão a ser encerrada
     */
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }

//    public static void closeConnection(Connection con, PreparedStatement stmt) {
//
//        closeConnection(con);
//
//        try {
//
//            if (stmt != null) {
//                stmt.close();
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
//
//        closeConnection(con, stmt);
//
//        try {
//
//            if (rs != null) {
//                rs.close();
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
