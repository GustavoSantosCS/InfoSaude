package br.udesc.ceavi.pin.infosaude.principal;

import br.udesc.ceavi.pin.infosaude.control.EnderecoControl;
import br.udesc.ceavi.pin.infosaude.control.VacinaControl;
import br.udesc.ceavi.pin.infosaude.modelo.Carterinha;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario_Logado;
import br.udesc.ceavi.pin.infosaude.view.frame.FramePrincipal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe Principal
 *
 * @author Gustavo
 * @version 1.0
 * @since 23/10/2018
 */
public class Main implements Runnable {

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread = new Thread(main);
        thread.start();

    }

    public static void setParametrosUsuario(Usuario_Logado usuarioRequerindo, Long id_endereco) {
        usuario = usuarioRequerindo;
        try {
            EnderecoControl controladoEndereco = new EnderecoControl();
            usuario.setEndereco(controladoEndereco.getEndereco(id_endereco));
        } catch (ClassNotFoundException | SQLException ex) {}
        if (usuario instanceof Usuario) {
            Carterinha carterinha = new Carterinha(((Usuario) usuario));
            try {
                VacinaControl controladorVacina = new VacinaControl();
                carterinha.setListaDeCampanhaParticipadas(controladorVacina.getCampanhaDoUsuario(((Usuario) usuario).getId_usuario()));
                controladorVacina = new VacinaControl();
                carterinha.setListaDeVacinaTomadas(controladorVacina.getVacinaDoUsuario(((Usuario) usuario).getId_usuario()));
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro Na Conexao Com o Banco, Não Foi Possivel Trazer Seus Dados da Carterira");
            }
        }
        if (usuario instanceof Profissional) {
        }
        if (usuario instanceof Instituicao) {
        }
    }

    public static Usuario_Logado usuario;

    @Override
    public void run() {
        try {
            FramePrincipal framePrincipal = new FramePrincipal(false);
            framePrincipal.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
