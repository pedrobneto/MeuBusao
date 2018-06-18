/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.dominio;

import javax.swing.JOptionPane;
import meubusao.Telas.LoginInicial;
import meubusao.Telas.TelaInicial;
import meubusao.back_end.LoginMananger;

/**
 *
 * @author Automatic
 */
public class MeuBusaoMain {
public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInicial().setVisible(true);
            }
        });
    }
}
