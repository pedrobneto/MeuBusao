/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meubusao.entidades;

/**
 *
 * @author Pedro Neto, Natália Brito
 */
public class Linha {
    private int id;
    private String nome;
    
    Linha(){}
    
    public Linha(int id, String nome) throws IllegalArgumentException {
        if(nome == null || nome.length() == 0) throw new IllegalArgumentException("nome não pode ser nulo");
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if(nome == null || nome.length() == 0) throw new IllegalArgumentException("nome não pode ser nulo");
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Linha{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
