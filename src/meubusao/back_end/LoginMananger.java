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
import meubusao.connection.ConnectionFactory;
import java.sql.*;

/**
 * Cuida do processo de login no sistema. Tenta minimizar a possibilidade de
 * injeção de SQL na tela de login.
 * @author Automatic
 */
public class LoginMananger {
    
    /**
    * Checa se tem existem caractéres que não sejam lowercase ou digitos uma string
    * @param str string a ser checada
    * @throws Exception Caractére inválido detectado na string passada
    */
    private static void warn(String str) throws RuntimeException{
        Character f = new Character('z');
       
        for (char c : str.toCharArray()){
            if (!(f.isLowerCase(c) || (f.isDigit(c))))
                throw new RuntimeException("Caractere inválido detectado.");;
        }
    }
    
    /**
     * Checa no fora do BD se existe um usuário "usr" no BD
     * @param usr usuário buscado
     * @return true se usuário existe no BD, false caso contrário.
     */
    private static Boolean userExists(String usr){
        String sql = "select usuario from Login";
        
        try{
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                if((usr.compareTo(rs.getNString(1)) == 0)) return true;
            }
            
            con.close();
            
        }catch(Exception e){System.err.println(e);}
        
        return false;
    }
    
    /**
     * Presupondo que o usuário existe, checa se uma senha é válida para este usuário
     * @param user usuário
     * @param pass senha
     * @return True
     */
    private static Boolean userMatchesPass(String user, String pas){
        String sql = "select senha from Login where usuario='" + user+"'";
        
        try{
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(); // deve ser um singleton
            
            while(rs.next()){ // Checa a senha atribuída ao usuário 'usr'
                if((pas.compareTo(rs.getNString(1)) == 0)) return true;
            }
            
            con.close();
            
        }catch(Exception e){System.err.println(e);}
        
        return false; // password não casa com usuário
    }
    
    /**
     * Tenta logar no sistema, com o nome de usuário e senha passado.
     * @param user_id
     * @param pass_id
     * @return
     * @throws RuntimeException Caso tenha acontecido algum erro na hora de logar
     */
    public static Boolean tryLogin(String user_id, String pass_id) throws RuntimeException{
        
        // checa se foram passados caracteres inválidos em algum dos campos.
        warn(user_id);
        warn(pass_id);
               
        if(userExists(user_id)){
            return userMatchesPass(user_id,pass_id);
        }
        else throw new RuntimeException("Usuário não existe ou combinação usuário+senha não é válido");
    }
}
