/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicaplayerofficial.Arvores;

/**
 *
 * @author cadoafb
 * @param <Type>
 */
public class No<Type extends Comparable> {
    
    private Type value;
    private No<Type> filhoEsquerda;
    private No<Type> filhoDireita;
    
    public No() {
        filhoEsquerda = null;
        filhoDireita = null;
    }
    
    public No(Type _value) {
        value = _value;
        filhoEsquerda = null;
        filhoDireita = null;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public No<Type> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(No<Type> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public No<Type> getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(No<Type> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }
    
    public boolean temFilho() {
        return filhoDireita != null || filhoEsquerda != null;         
    }
    
    public Type getUser() {
        return this.value;
    }
}
