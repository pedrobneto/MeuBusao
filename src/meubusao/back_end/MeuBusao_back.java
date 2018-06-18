/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.back_end;

/**
 *
 * @author pedroarthur-mf
 */
import meubusao.dao.OnibusDAO;
import meubusao.entidades.Onibus;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Automatic
 */
public class MeuBusao_back {
    
    /**
     * Argumentos do driver;
     */
    static final String USER = "root";
    static final String PASS = "aluno";
    static final String URLSTR = "jdbc:mysql://localhost:3306/meubusao";

    /**
     * Tries to estabilish a connection with de data bank.
     * @return the connection.
     */
    public static Connection tryConnect() throws Exception {
        Connection conn = null;
        
        conn = DriverManager.getConnection(URLSTR,USER,PASS);
        System.out.println("Connection success!");       
        
        return conn;
    }
    
    /**
     * Enche o BD para testes
     * @param conn conexão válida comum servidor
     * @throws SQLException 
     */
    public static void fillBD(Connection conn) throws SQLException {
        PreparedStatement pstm = conn.prepareStatement("INSERT INTO login VALUES ('adm','adm')");
        pstm.execute();
    }
    
    public static ArrayList<Onibus> testOnibusCreateRead (Onibus o){
        // create
        OnibusDAO.create(o);
        //read
        ArrayList<Onibus> estate = OnibusDAO.read();
        
        return estate;
    }
        
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        try{
//            //fillBD(conn);
//            
//            //tentando login
//            Scanner s = new Scanner(System.in);
//            String user;
//            String pass;
//            
//            System.out.println(">> Entre o usuário.");
//            user = s.nextLine();
//            System.out.println(">> Entre a senha.");
//            pass = s.nextLine();
//            System.out.println(">> Tentando logar...");
//            
//            if (LoginMananger.tryLogin(user,pass)){
//                System.out.println(">> Sucesso!");
//                ArrayList<Onibus> res1 = testOnibusCreateRead(new Onibus("1234567", 9)); // plausivel de bom
//                System.out.println("Resultados:");
//                for (Onibus o : res1){
//                    System.out.println("placa=" + o.getPlaca() +", situ= " + o.getSituacao());
//                }
//            }else System.out.println(">> Falha!");
//            
//            //teste onibus            
//            
//            
//            //fim
//            System.out.println(">> Fim.");
//            
//        }catch (Exception e){System.err.println(e);}
//    }  
}
