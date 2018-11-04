package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.List;

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

    private List<Vacina> listaVacina;

    //Construtor
    public Usuario() {
        super();
    }

    //Construtor
    public Usuario(List<Vacina> listaVacina) {
        super();
        this.listaVacina = listaVacina;
    }

    public List<Vacina> getListaVacina() {
        return listaVacina;
    }

    public void setListaVacina(List<Vacina> listaVacina) {
        this.listaVacina = listaVacina;
    }

}
