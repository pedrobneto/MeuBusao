/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaplayerofficial.exception;

import javax.swing.JOptionPane;

/**
 *
 * @author cadoafb
 */
public class SenhaIncorretaException extends Exception {

    public SenhaIncorretaException() {
    }

    
    /**
     * Método que trata o erro de tentativa de login com usuario errado
     * @return "A senha digitada é incorreta"
     */
    @Override
    public String getMessage() {
        return "A senha digitada é incorreta";
    }
    
    
    
}
