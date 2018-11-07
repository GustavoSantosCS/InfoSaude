package br.udesc.ceavi.pin.infosaude.modelo;

/**
 * Esta enumerado representa o sexo do usuario
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public enum Sexo {

    M("M"),
    F("F");

    private final String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.sexo;
    }

}
