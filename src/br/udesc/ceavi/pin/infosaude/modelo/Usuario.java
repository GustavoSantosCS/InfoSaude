package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.Date;

/**
 * Esta Classe define os atributos do Usuario
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class Usuario extends Pessoa {

    private Carterinha carterinha;

    //Construtor
    public Usuario(Carterinha carterinha) {
        this.carterinha = carterinha;
    }

    //Construtor
    public Usuario(Carterinha carterinha, long id, String nome) {
        super(id, nome);
        this.carterinha = carterinha;
    }

    //Construtor
    public Usuario(Carterinha carterinha, String cpf, Date dataNascimento, String login, String nome, String numeroSUS, String registroGeral, String senha, Sexo sexo, Endereco endereco) {
        super(cpf, dataNascimento, login, nome, numeroSUS, registroGeral, senha, sexo, endereco);
        this.carterinha = carterinha;
    }
    
    //Construtor
    public Usuario() {
        super();
    }

    public Carterinha getCarterinha() {
        return carterinha;
    }

}
