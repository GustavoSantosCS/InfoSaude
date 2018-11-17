package br.udesc.ceavi.pin.infosaude.modelo;

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

    //Construtor
    public Profissional() {
        super();
    }

    //Construtor
    public Profissional(long id, String nome) {
        super(id,nome);
    }

    //Construtor
    public Profissional(String nome) {
        super("", null, "", nome, "", "", "", Sexo.F, null);
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
