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
    private Long id_usuario;

    public Usuario(Long id_pessoa,Long id_usuario, String cpf, Date dataNascimento, 
            String login, String nome, String numeroSUS, String registroGeral, String senha, Sexo sexo) {
        super(id_pessoa, cpf, dataNascimento, login, nome, numeroSUS, registroGeral, senha, sexo);
        this.id_usuario = id_usuario;
    }

    public Usuario(Pessoa pessoa) {
        super(pessoa.getId(),pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getLogin(), pessoa.getNome(), pessoa.getNumeroSUS(), pessoa.getRegistroGeral(), pessoa.getSenha(), pessoa.getSexo(), pessoa.getEndereco());
    }


    public Carterinha getCarterinha() {
        return carterinha;
    }

    public void setCarterinha(Carterinha carterinha) {
        this.carterinha = carterinha;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

}
