package meubusao.entidades;

/**
 * @author Natália Brito
 */
public class Motorista {
    
    private String nome;
    private String cpf;
    private int situacao;

    public Motorista(String nome, String cpf, int situacao) throws IllegalArgumentException{
        if(nome == null || nome.length() == 0) throw new IllegalArgumentException("nome não pode ser nulo");
        this.nome = nome;
        if(cpf == null || cpf.length() != 11) throw new IllegalArgumentException("cpf deve ter 11 caracteres");
        this.cpf = cpf;
        if(situacao < 0 || situacao > 9) throw new IllegalArgumentException("situação deve ser entre 0 e 9");
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException{
        if(nome == null || nome.length() == 0) throw new IllegalArgumentException("nome não pode ser nulo");
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException{
        if(cpf == null || cpf.length() != 11) throw new IllegalArgumentException("cpf deve ter 11 caracteres");
        this.cpf = cpf;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) throws IllegalArgumentException{
        if(situacao < 0 || situacao > 9) throw new IllegalArgumentException("situação deve ser entre 0 e 9");
        this.situacao = situacao;
    }
    
    @Override
    public String toString(){
        return (this.getNome() + " " + this.getCpf());
    }
}
