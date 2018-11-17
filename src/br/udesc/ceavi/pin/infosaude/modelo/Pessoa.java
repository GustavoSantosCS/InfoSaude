package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.Date;

/**
 * Esta Classe define os atributos de Pessoa
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class Pessoa implements Usuario_Logado{

    private long id;
    private String cpf;
    private Date dataNascimento;
    private String login;
    private String nome;
    private String numeroSUS;
    private String registroGeral;
    private String senha;
    private Sexo sexo;
    private Endereco endereco;
    
    //Construtor
    public Pessoa(long id,String nome) {    
        this.id = id;
        this.nome = nome;
    }

    //Construtor
    public Pessoa() {
        super();
        this.nome = "Teste InfoSaude";
    }

    //Construtor
    public Pessoa(String cpf, Date dataNascimento, String login, String nome, String numeroSUS, String registroGeral, String senha, Sexo sexo, Endereco endereco) {
        super();
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.nome = nome;
        this.numeroSUS = numeroSUS;
        this.registroGeral = registroGeral;
        this.senha = senha;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroSUS() {
        return numeroSUS;
    }

    public void setNumeroSUS(String numeroSUS) {
        this.numeroSUS = numeroSUS;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getUsuario() {
        return nome;
    }

}
