package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta Classe define os atributos de Vacina
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class Vacina {

    private long id;
    private Date dataAplicacao;
    private float dose;
    private String vacina;
    private Profissional profissional;
    private List<PublicoAlvo> publicosAlvos;
    private String observacao;

    //Construtor
    public Vacina() {
        super();
    }

    //Construtor
    public Vacina(Date dataAplicacao, float dose, String vacina, Profissional profissional, List<PublicoAlvo> publicosAlvos) {
        super();
        this.dataAplicacao = dataAplicacao;
        this.dose = dose;
        this.vacina = vacina;
        this.profissional = profissional;
        this.publicosAlvos = publicosAlvos;
    }

    public Vacina(Date dataAplicacao, float dose, String vacina, Profissional profissional, PublicoAlvo publicosAlvos) {
        super();
        this.dataAplicacao = dataAplicacao;
        this.dose = dose;
        this.vacina = vacina;
        this.profissional = profissional;
        this.publicosAlvos = new ArrayList<>();
        this.publicosAlvos.add(publicosAlvos);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public List<PublicoAlvo> getPublicosAlvos() {
        return publicosAlvos;
    }

    public void setPublicosAlvos(List<PublicoAlvo> publicosAlvos) {
        this.publicosAlvos = publicosAlvos;
    }

}
