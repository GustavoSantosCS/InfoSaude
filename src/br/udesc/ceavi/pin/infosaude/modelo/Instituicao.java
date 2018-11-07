package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.List;

/**
 * Esta Classe define os atributos da Instituição
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class Instituicao {

    private long id;
    private String cnpj;
    private String nome;
    private String senha;
    private Endereco endereco;
    private List<Profissional> listaDeProfissionais;
    private List<Campanha> campanhas;

    //Construtor
    public Instituicao() {
        super();
    }

    //Construtor
    public Instituicao(String cnpj, String nome, Endereco endereco, List<Profissional> listaDeProfissionais, List<Campanha> campanhas) {
        super();
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.listaDeProfissionais = listaDeProfissionais;
        this.campanhas = campanhas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Profissional> getListaDeProfissionais() {
        return listaDeProfissionais;
    }

    public void setListaDeProfissionais(List<Profissional> listaDeProfissionais) {
        this.listaDeProfissionais = listaDeProfissionais;
    }

    public List<Campanha> getCampanhas() {
        return campanhas;
    }

    public void setCampanhas(List<Campanha> campanhas) {
        this.campanhas = campanhas;
    }

}
