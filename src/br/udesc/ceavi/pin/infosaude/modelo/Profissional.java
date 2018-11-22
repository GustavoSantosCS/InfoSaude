package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.Date;

/**
 * Esta Classe define os atributos do Profissional
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class Profissional extends Pessoa {

    private Instituicao instituicao;
    private Long id_profissional;

    //Construtor
    public Profissional() {
        super();
    }

    public Profissional(Long id_pessoa, Long id_profissional, String cpf, Date dataNascimento,
            String login, String nome, String numeroSUS, String registroGeral, String senha, Sexo sexo) {
        super(id_pessoa, cpf, dataNascimento, login, nome, numeroSUS, registroGeral, senha, sexo);
        this.id_profissional = id_profissional;
    }

    //Construtor
    public Profissional(long id_pessoa,Long id_profissional, String nome) {
        super.setNome(nome);
        super.setId(id_pessoa);
        this.id_profissional = id_profissional;
    }

    //Construtor
    public Profissional(Instituicao instituicao) {
        super();
        this.instituicao = instituicao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

}
