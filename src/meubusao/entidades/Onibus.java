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
public class Onibus {
    
    private String placa;
    private Integer situacao;
    
    public Onibus (String placa, Integer situacao) throws IllegalArgumentException{
        if(placa == null || placa.length() != 7) throw new IllegalArgumentException("placa deve conter 7 caractéres");
        this.placa = placa;
        if(situacao == null || (situacao < 0 || situacao > 9)) throw new IllegalArgumentException("situação deve ser entre 0 e 9");
        this.situacao = situacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws IllegalArgumentException{
        if(placa == null || placa.length() != 7) throw new IllegalArgumentException("placa deve conter 7 caractéres");
        this.placa = placa;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) throws IllegalArgumentException{
        if(situacao == null || (situacao < 0 || situacao > 9)) throw new IllegalArgumentException("situação deve ser entre 0 e 9");
        this.situacao = situacao;
    }
    
    @Override
    public String toString(){
        return (this.getPlaca() + " " + this.getSituacao().toString());
    }
}
