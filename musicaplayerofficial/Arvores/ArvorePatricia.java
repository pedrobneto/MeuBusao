/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaplayerofficial.Arvores;

/**
 *
 * @author cadoafb
 */
public class ArvorePatricia<Type extends Comparable<Type>> {
    
    private PatNo raiz;
    private int nbitsChave;
    
    
    private static abstract class PatNo{}
    private static class PatNoInt extends PatNo{
        int index;
        PatNo esq, dir;
    }
    
    private static class PatNoExt extends PatNo{
        char chave;
    }
    
    //Entram aqui os metodos privados dos programas
    public ArvorePatricia(int nbitsChave) {
        this.raiz = null;
        this.nbitsChave = nbitsChave;
    }
    
    public void pesquisa (char k) {
        //this.pesquisa (k,this.raiz);
    }
    
}
