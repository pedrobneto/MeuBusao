/*
 *Classe reponsavel
 */
package musicaplayerofficial.Arvores;

import musicaplayerofficial.Usuario.UsuarioBase;
import sun.security.jca.GetInstance;

/**
 *
 * @author cadoafb
 */
public class BancoArvores {

    private static BancoArvores bancoArv;
    private ArvoreBinariaBusca<UsuarioBase> arvore;

    private BancoArvores() {
        BancoArvores.bancoArv = null;
    }
    
    /**
     * Instancia o objeto da classe
     * @return 
     */
    public static BancoArvores getInstance() {
        if(bancoArv == null)
            bancoArv = new BancoArvores();
        return bancoArv;
    }

    public ArvoreBinariaBusca<UsuarioBase> getArvore() {
        return arvore;
    }

    public void setArvore(ArvoreBinariaBusca<UsuarioBase> arvore) {
        this.arvore = arvore;
    }
    
    
    
}
