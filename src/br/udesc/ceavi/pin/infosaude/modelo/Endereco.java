package br.udesc.ceavi.pin.infosaude.modelo;

/**
 * Esta Classe define os atributos de Endereço
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class Endereco {

    private long id;
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private int numero;
    private String rua;
    private Estado estado;
    private String email;
    private String telefone;

    //Construtor
    public Endereco() {
        super();
    }

    //Construtor
    public Endereco(String bairro, String cep, String cidade, String complemento, String email, int numero, String rua, String telefone, Estado estado) {
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.email = email;
        this.numero = numero;
        this.rua = rua;
        this.telefone = telefone;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
