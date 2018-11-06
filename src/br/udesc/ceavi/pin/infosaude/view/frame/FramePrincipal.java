package br.udesc.ceavi.pin.infosaude.view.frame;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.view.component.MenuJPaneUniversao;
import br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author gusta
 */
public class FramePrincipal extends javax.swing.JFrame {

    private MenuJPaneUniversao menu;
    
//    Connection con = null;
    ConexaoPostgresJDBC conJDBC;

    /**
     * Creates new form NewJFrame
     */
    public FramePrincipal() throws ClassNotFoundException, SQLException {
        this.conJDBC = new ConexaoPostgresJDBC();
        initComponents();
        initComponentsExtenal();
        conJDBC.getConnection();
    }

    public void initComponentsExtenal() {
        setSize(jpTopo, new Dimension(this.getSize().width - 286, 130));
        setSize(jpColuna, new Dimension(286, this.getSize().height));
        this.setMinimumSize(new Dimension(993, 647));
        setSize(tfBusca, new Dimension(52, 32));
        setSize(lbTitulo, new Dimension(280, 30));
        setSize(lbBusca, new Dimension(26, 26));
        menu = new MenuJPaneUniversao(this.jpColuna.getSize().width);
        jpMenu.add(menu);
        menu.menuSemUsuario();
        addPanel(new InternalFrameLancamentoDeVacina());
    }

    public void addPanel(JInternalFrame frame) {
        jDesktopPane1.removeAll();
        frame.setMinimumSize(this.jDesktopPane1.getSize());
        ((BasicInternalFrameUI) frame.getUI()).setNorthPane(null); //retirar o painel superior
        frame.setBorder(null);
        frame.setVisible(true);
        jDesktopPane1.add(frame, BorderLayout.BEFORE_FIRST_LINE);
        try {
            frame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Erro Não Aguardado");
            this.dispose();
        }
        lbTitulo.setText("" + frame.getTitle());
    }

    public void setSize(Component c, Dimension size) {
        c.setMinimumSize(size);
        c.setSize(size);
        c.setPreferredSize(size);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpColuna = new javax.swing.JPanel();
        lbTituloMenu = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jpMenu = new javax.swing.JPanel();
        jpTopo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        tfBusca = new javax.swing.JTextField();
        lbBusca = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InfoSaude - Login");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jpColuna.setBackground(new java.awt.Color(195, 195, 195));
        jpColuna.setForeground(new java.awt.Color(195, 195, 195));
        jpColuna.setMinimumSize(new java.awt.Dimension(286, 1040));
        jpColuna.setPreferredSize(new java.awt.Dimension(286, 1040));

        lbTituloMenu.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbTituloMenu.setText("InfoSaúde");

        btnSair.setBackground(new java.awt.Color(204, 0, 0));
        btnSair.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorder(null);
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jpMenu.setBackground(new java.awt.Color(195, 195, 195));
        jpMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        java.awt.GridBagLayout jpMenuLayout = new java.awt.GridBagLayout();
        jpMenuLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        jpMenuLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        jpMenu.setLayout(jpMenuLayout);

        javax.swing.GroupLayout jpColunaLayout = new javax.swing.GroupLayout(jpColuna);
        jpColuna.setLayout(jpColunaLayout);
        jpColunaLayout.setHorizontalGroup(
            jpColunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpColunaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpColunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTituloMenu)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        jpColunaLayout.setVerticalGroup(
            jpColunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpColunaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbTituloMenu)
                .addGap(60, 60, 60)
                .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addGap(50, 50, 50))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jpColuna, gridBagConstraints);

        jpTopo.setBackground(new java.awt.Color(63, 72, 204));
        jpTopo.setForeground(new java.awt.Color(63, 72, 204));

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setText("InfoSaúde - Login");

        tfBusca.setBackground(new java.awt.Color(63, 72, 204));
        tfBusca.setForeground(new java.awt.Color(153, 217, 224));
        tfBusca.setText("Buscar");
        tfBusca.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        tfBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpTopoLayout = new javax.swing.GroupLayout(jpTopo);
        jpTopo.setLayout(jpTopoLayout);
        jpTopoLayout.setHorizontalGroup(
            jpTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpTopoLayout.setVerticalGroup(
            jpTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTopoLayout.createSequentialGroup()
                        .addGroup(jpTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBusca)
                            .addComponent(tfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jpTopo, gridBagConstraints);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jDesktopPane1, gridBagConstraints);

        setSize(new java.awt.Dimension(818, 647));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.out.println("Tamanho da Frame: " + this.getSize());
        System.out.println("Tamanho da panel: " + this.jDesktopPane1.getSize());
        System.out.println("Tamanho da internal frame: " + this.jDesktopPane1.getAllFrames()[0].getSize());
        this.dispose();
        conJDBC.close();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        btnSair.setBackground(new java.awt.Color(140, 12, 15));
        btnSair.revalidate();
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        btnSair.setBackground(new java.awt.Color(204, 0, 0));
        btnSair.revalidate();
    }//GEN-LAST:event_btnSairMouseExited

    private void tfBuscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaFocusGained
        tfBusca.setBackground(new Color(255, 255, 255));
        tfBusca.setBorder(new BasicBorders.ButtonBorder(new Color(0, 0, 0),
                new Color(141, 141, 225),
                new Color(141, 141, 225),
                new Color(141, 141, 225)));
        tfBusca.setText("");
        tfBusca.revalidate();
    }//GEN-LAST:event_tfBuscaFocusGained

    private void tfBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscaFocusLost
        tfBusca.setBackground(new java.awt.Color(63, 72, 204));
        tfBusca.setBorder(null);
        if (tfBusca.getText().length() == 0) {
            tfBusca.setText("Buscar");
        }
        tfBusca.revalidate();
    }//GEN-LAST:event_tfBuscaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jpColuna;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpTopo;
    private javax.swing.JLabel lbBusca;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTituloMenu;
    private javax.swing.JTextField tfBusca;
    // End of variables declaration//GEN-END:variables
}