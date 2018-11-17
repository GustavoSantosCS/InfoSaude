package br.udesc.ceavi.pin.infosaude.view.frame.listener;

import br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao.InternalFrameCadastroPessoa;
import br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao.InternalFrameInstituicao;
import br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao.InternalFrameLogin;
import br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao.InternalFrameTelaInicial;
import br.udesc.ceavi.pin.infosaude.view.frame.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * @author Gustavo C. Santos
 */
public class ListenerMenuSemUsuario implements Listener {

    private final FramePrincipal tela;
    private JInternalFrame campoAcaoAtual;
    private JInternalFrame campoAcaoObjetivo;
    private final List<JButton> listaDeButao;

    public ListenerMenuSemUsuario(List<JButton> listaDeButao, FramePrincipal tela) {
        this.listaDeButao = listaDeButao;
        this.tela = tela;
        addActions();
    }

    @Override
    public void addActions() {
        listaDeButao.get(0).addActionListener(new btnAction0Listener());
        listaDeButao.get(1).addActionListener(new btnAction1Listener());
        listaDeButao.get(2).addActionListener(new btnAction2Listener());
        listaDeButao.get(3).addActionListener(new btnAction3Listener());
        listaDeButao.get(4).addActionListener(new btnAction4Listener());
    }

    private class btnAction0Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            tela.addPanel(new InternalFrameTelaInicial());
        }
    }

    private class btnAction1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            tela.addPanel(new InternalFrameLogin());
        }
    }

    private class btnAction2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            tela.addPanel(new InternalFrameCadastroPessoa());
        }
    }

    private class btnAction3Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            tela.addPanel(new InternalFrameInstituicao());
        }
    }

    private class btnAction4Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(tela, "Telefone : (000) 0800-000 \n"
                    + "Email: infosaude@contato.com");
        }
    }
}
