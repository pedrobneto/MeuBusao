/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import java.sql.*;
import meubusao.entidades.Onibus;
import meubusao.connection.ConnectionFactory;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Natália
 */
public class OnibusDAO {
    
    public static void create(Onibus t) throws SQLException {     
        if (t != null){
            Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
            // Tenta inserir o ônibus na tabela
            try{
                // prepara statement de inserção
                PreparedStatement stm = con.prepareStatement("INSERT INTO onibus VALUES (?,?)");
                stm.setString(1,t.getPlaca());
                stm.setInt(2,t.getSituacao());
                
                stm.execute(); // executa o statement
                
                stm.close();
                con.close();
                
            }catch(SQLException e){
                System.err.println(e);
                throw e;
            }
        }
    }
    
    /**
     * Recupera um ArrayList com todos os ônibus do banco.
     * @return Um ArrayList com os possíveis resultados. (pode ser null)
     */    
    public static ArrayList<Onibus> read () throws SQLException{
        
        ArrayList<Onibus> t_list = null;

        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
        // Tenta selecionar o ônibus na tabela
        try{
            // prepara statement de inserção
            PreparedStatement stm = con.prepareStatement("SELECT * FROM onibus");

            ResultSet rs = stm.executeQuery();

            t_list = new ArrayList<Onibus>();

            while (rs.next()){
                Onibus new_t = new Onibus(rs.getNString(1),rs.getInt(2));
                t_list.add(new_t);
            } 

            stm.close();
            con.close();

            return t_list;


        }catch(SQLException e){ 
            System.err.println(e);
            throw e;
        }finally{                
            return t_list;
        }
    }
    
    /**
     * Atualiza o Onibus passado para o BD (placa e situacao, baseado na placa original)
     * @param t 
     */
    public static void update(Onibus t) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
        // Tenta selecionar o ônibus na tabela
        try{
            // prepara statement de inserção
            PreparedStatement stm = con.prepareStatement("UPDATE onibus SET placa =?, situacao=? WHERE placa='" + t.getPlaca() +"'");
            stm.setString(1,t.getPlaca());
            stm.setInt(2,t.getSituacao());

            stm.executeUpdate();
                    
            stm.close();
            con.close();
        }catch(SQLException e){
            System.err.println(e);
            throw e;
        }
    }
    
    public static void delete(ArrayList<Onibus> ts) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
        // Tenta selecionar o ônibus na tabela
        try{
            // prepara statement de inserção
            PreparedStatement stm = con.prepareStatement("DELETE FROM onibus WHERE placa=?");
            
            //remove os osnibus
            for(Onibus bus : ts){
                stm.setString(1,bus.getPlaca());

                stm.executeUpdate();
            }
            
            // fecha conexão
            stm.close();
            con.close();
        }catch(SQLException e){ 
            System.err.println(e);
            throw e;
        }
    }
}