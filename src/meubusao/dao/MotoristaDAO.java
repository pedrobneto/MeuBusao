/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dao;

import meubusao.connection.ConnectionFactory;
import meubusao.entidades.Motorista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Automatic
 */
public class MotoristaDAO {
    
    public static void create(Motorista t) throws SQLException{     
        if (t != null){
            Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
            // Tenta inserir o motorista na tabela
            try{
                // prepara statement de inserção
                PreparedStatement stm = con.prepareStatement("INSERT INTO motorista VALUES (?,?,?)");  //cpf INT(11), nome(VARCHAR(45), situacao INT(1)
                stm.setInt(1,Integer.parseInt(t.getCpf()));
                stm.setString(2,t.getNome());
                stm.setInt(3,t.getSituacao());
                
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
     * Recupera um ArrayList com todos os motoristas do banco.
     * @return Um ArrayList com os possíveis resultados. (pode ser null)
     */    
    public static ArrayList<Motorista> read () throws SQLException{
        
        ArrayList<Motorista> t_list = null;

        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
        // Tenta selecionar o ônibus na tabela
        try{
            // prepara statement de inserção
            PreparedStatement stm = con.prepareStatement("SELECT * FROM motorista");

            ResultSet rs = stm.executeQuery();

            t_list = new ArrayList<Motorista>();

            while (rs.next()){
                Motorista new_t = new Motorista(rs.getString(1),rs.getString(2),rs.getInt(3)); //cpf INT(11), nome(VARCHAR(45), situacao INT(1)
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
     * Atualiza o Motorista passado para o BD (placa e situacao, baseado na placa original)
     * @param o 
     */
    public static void update(Motorista t) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
        // Tenta selecionar o ônibus na tabela
        try{
            // prepara statement de inserção
            PreparedStatement stm = con.prepareStatement("UPDATE motorista SET cpf =?, nome='?', situacao=? WHERE cpf='" + t.getCpf() +"'");
            stm.setInt(1,Integer.parseInt(t.getCpf()));
            stm.setString(2,t.getNome());
            stm.setInt(3,t.getSituacao());

            stm.executeUpdate();
                    
            stm.close();
            con.close();

        }catch(SQLException e){
            System.err.println(e);
            throw e;
        }
    }
    
    public static void delete(ArrayList<Motorista> ts) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection(); // tenta estabelecer conexão com o BD
            
        // Tenta selecionar o ônibus na tabela
        try{
            // prepara statement de inserção
            PreparedStatement stm = con.prepareStatement("DELETE FROM motorista WHERE cpf=?");
            
            //remove os osnibus
            for(Motorista t : ts){
                stm.setInt(1,Integer.parseInt(t.getCpf()));;

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
