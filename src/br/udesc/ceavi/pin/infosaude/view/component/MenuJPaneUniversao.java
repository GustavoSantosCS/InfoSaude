package br.udesc.ceavi.pin.infosaude.view.component;

import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario_Logado;
import br.udesc.ceavi.pin.infosaude.principal.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    public MenuJPaneUniversao(int largura) {
        di = new Dimension(largura - 15, 360);
        initComponents();
        getVerificaUsuario();
    }

    public void menuSemUsuario() {
        addButao(new JButton("Home"), null);
        addButao(new JButton("Login"), null);
        addButao(new JButton("Cadastrar"), null);
        addButao(new JButton("Contato"), null);
    }

    public void menuUsuarioComum() {
        addButao(new JButton("Home"), null);
        addButao(new JButton("Consultar Vacinas"), null);
        addButao(new JButton("Consultar Campanhas"), null);       
        addButao(new JButton("Dados Pessoais"), null);
        addButao(new JButton("Contato"), null);
    }

    public void menuUsuarioProfissional() {
        addButao(new JButton("Home"), null);
        addButao(new JButton("Consultar Vacinas"), null);
        addButao(new JButton("Cadastrar Usuarios"), null);       
        addButao(new JButton("Cadastrar Campanhas"), null);
        addButao(new JButton("Relatórios"), null);
        addButao(new JButton("Contato"), null);
    }

    public void menuUsuarioInstituicao() {
        addButao(new JButton("Home"), null);
        addButao(new JButton("Consultar Vacinas"), null);
        addButao(new JButton("Cadastrar Profissional"), null);       
        addButao(new JButton("Cadastrar Campanhas"), null);
        addButao(new JButton("Relatórios"), null);
        addButao(new JButton("Contato"), null);
    }
    public void initMenu(){
        
    }

    public void addButao(JButton btn, ActionListener actionListener) {
        btn.setSize(btnDimesion);
        btn.setFont(new Font("Tahoma", 0, 24));
        btn.setBorder(null);
        btn.setBackground(new Color(225, 225, 225));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.addMouseListener((MouseListener) new MouseListenner(btn));
        if (actionListener != null) {
            btn.addActionListener(actionListener);
        }

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
        if(verifica instanceof Profissional){
            menuUsuarioProfissional();
        }
        if(verifica instanceof Instituicao){
            menuUsuarioInstituicao();
        }
        if(verifica == null){
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
