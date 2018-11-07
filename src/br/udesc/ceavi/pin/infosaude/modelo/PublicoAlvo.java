package br.udesc.ceavi.pin.infosaude.modelo;

/**
 * Esta Classe define os atributos do Publico Alvo
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class PublicoAlvo {

    private long id;
    private int maxIdade;
    private int minIdade;
    private Sexo sexo;

    //Construtor
    public PublicoAlvo() {
        super();
    }

    //Construtor
    public PublicoAlvo(int maxIdade, int minIdade, Sexo sexo) {
        super();
        this.maxIdade = maxIdade;
        this.minIdade = minIdade;
        this.sexo = sexo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMaxIdade() {
        return maxIdade;
    }

    public void setMaxIdade(int maxIdade) {
        this.maxIdade = maxIdade;
    }

    public int getMinIdade() {
        return minIdade;
    }

    public void setMinIdade(int minIdade) {
        this.minIdade = minIdade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Idade Maxima= " + maxIdade + " Idade Minima= " + minIdade + " Sexo=" + sexo;
    }

}
