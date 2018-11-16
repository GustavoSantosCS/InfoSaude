package br.udesc.ceavi.pin.infosaude.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta Classe define os atributos de Endereço
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 15/11/2018
 */public class Carterinha {
     private final Pessoa usuario;
     private List<Vacina> listaDeVacinaTomadas = new ArrayList<>(); 
     private List<Campanha> listaDeCampanhaParticipadas  = new ArrayList<>();

    public Carterinha(Pessoa usuario) {
        this.usuario = usuario;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public Vacina getVacinaPorNome(String nome) {
        if(this.listaDeVacinaTomadas.isEmpty())
        for (int i = 0; i < listaDeVacinaTomadas.size(); i++) {
            if(listaDeVacinaTomadas.get(i).getVacina().equals(nome)){
                return listaDeVacinaTomadas.get(i);
            }
        }
        return null;
    }

    public Campanha getCampanhaPorNome(String nome) {
        if(this.listaDeCampanhaParticipadas.isEmpty())
        for (int i = 0; i < listaDeCampanhaParticipadas.size(); i++) {
            if(listaDeCampanhaParticipadas.get(i).getVacina().equals(nome)){
                return listaDeCampanhaParticipadas.get(i);
            }
        }
        return null;
    }

    public boolean setListaDeCampanhaParticipadas(List<Campanha> listaDeCampanhaParticipadas) {
        return true;
    }

    public boolean setListaDeVacinaTomadas(List<Vacina> listaDeVacinaTomadas) {
        return true;
    }
    
}
