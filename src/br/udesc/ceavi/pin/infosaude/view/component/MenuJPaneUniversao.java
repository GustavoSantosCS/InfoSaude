package br.udesc.ceavi.pin.infosaude.view.component;

import br.udesc.ceavi.pin.infosaude.view.frame.listener.ListenerMenuUsuarioComum;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario_Logado;
import br.udesc.ceavi.pin.infosaude.principal.Main;
import br.udesc.ceavi.pin.infosaude.view.frame.FramePrincipal;
import br.udesc.ceavi.pin.infosaude.view.frame.listener.Listener;
import br.udesc.ceavi.pin.infosaude.view.frame.listener.ListenerMenuSemUsuario;
import br.udesc.ceavi.pin.infosaude.view.frame.listener.ListenerMenuUsuarioIntituicao;
import br.udesc.ceavi.pin.infosaude.view.frame.listener.ListenerMenuUsuarioProfissional;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author gusta
 */
public class MenuJPaneUniversao extends javax.swing.JPanel {

    private Dimension btnDimesion = new Dimension(135, 30);
    private int consX = 1;
    private GridBagConstraints cons;
    private Dimension di;
    private Listener listener;
    private final FramePrincipal tela;

    public MenuJPaneUniversao(int largura, FramePrincipal tela) {
        di = new Dimension(largura - 15, 360);
        initComponents();
        this.tela = tela;
        getVerificaUsuario();
    }

    public void menuSemUsuario() {
        List<JButton> lista = new ArrayList<>();
        lista.add(new JButton("Home"));
        lista.add(new JButton("Login"));
        lista.add(new JButton("Cadastar Pessoa"));
        lista.add(new JButton("Cadastar Intituição"));
        lista.add(new JButton("Contato"));
        listener = new ListenerMenuSemUsuario(lista, tela);
        for (int i = 0; i < lista.size(); i++) {
            addButao(lista.get(i));
        }
    }

    public void menuUsuarioComum() {
        List<JButton> lista = new ArrayList<>();
        lista.add(new JButton("Home"));
        lista.add(new JButton("Consultar Vacinas"));
        lista.add(new JButton("Consultar Campanhas"));
        lista.add(new JButton("Dados Pessoais"));
        lista.add(new JButton("Contato"));
        listener = new ListenerMenuUsuarioComum(lista, tela);
        for (int i = 0; i < lista.size(); i++) {
            addButao(lista.get(i));
        }
    }

    public void menuUsuarioProfissional() {
        List<JButton> lista = new ArrayList<>();
        lista.add(new JButton("Home"));
        lista.add(new JButton("Consultar Vacinas"));
        lista.add(new JButton("Cadastrar Usuarios"));
        lista.add(new JButton("Cadastrar Campanhas"));
        lista.add(new JButton("Relatórios"));
        lista.add(new JButton("Contato"));
        listener = new ListenerMenuUsuarioProfissional(lista,tela);
        for (int i = 0; i < lista.size(); i++) {
            addButao(lista.get(i));
        }
    }

    public void menuUsuarioInstituicao() {
        List<JButton> lista = new ArrayList<>();
        lista.add(new JButton("Home"));
        lista.add(new JButton("Consultar Vacinas"));
        lista.add(new JButton("Cadastrar Profissional"));
        lista.add(new JButton("Cadastrar Campanhas"));
        lista.add(new JButton("Relatórios"));
        lista.add(new JButton("Contato"));
        listener = new ListenerMenuUsuarioIntituicao(lista,tela);
        for (int i = 0; i < lista.size(); i++) {
            addButao(lista.get(i));
        }
    }

    public void initMenu() {

    }

    public void addButao(JButton btn) {
        btn.setSize(btnDimesion);
        btn.setFont(new Font("Tahoma", 0, 24));
        btn.setBorder(null);
        btn.setBackground(new Color(225, 225, 225));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.addMouseListener((MouseListener) new MouseListenner(btn));

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = consX;
        cons.weightx = 1.0;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.insets = new Insets(7, 10, 7, 10);
        this.add(btn, cons);
        consX++;
    }

    private class MouseListenner implements MouseListener {

        JButton btn;

        public MouseListenner(JButton botao) {
            this.btn = botao;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            btn.setBackground(new Color(46, 179, 211));
            btn.revalidate();
        }

        @Override
        public void mouseExited(MouseEvent me) {
            btn.setBackground(new Color(225, 225, 225));
            btn.revalidate();
        }

    }

    public void getVerificaUsuario() {
        Usuario_Logado verifica = Main.privilegio;
        if (verifica instanceof Usuario) {
            menuUsuarioComum();
        }
        if (verifica instanceof Profissional) {
            menuUsuarioProfissional();
        }
        if (verifica instanceof Instituicao) {
            menuUsuarioInstituicao();
        }
        if (verifica == null) {
            menuSemUsuario();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbTitulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(195, 195, 195));
        setLayout(new java.awt.GridBagLayout());

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Menu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 35, 0);
        add(lbTitulo, gridBagConstraints);
        GridBagLayout jpMenuLayout = (GridBagLayout) this.getLayout();
        jpMenuLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        jpMenuLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        this.setSize(di);
        this.setPreferredSize(di);
        this.setMaximumSize(di);
        this.setMinimumSize(di);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
