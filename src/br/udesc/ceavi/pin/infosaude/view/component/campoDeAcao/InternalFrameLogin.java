package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.control.PessoaControl;
import br.udesc.ceavi.pin.infosaude.view.frame.FramePrincipal;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class InternalFrameLogin extends javax.swing.JInternalFrame {

    Dimension dB = new Dimension(120, 30);
    Dimension dt = new Dimension(250, 27);
    FramePrincipal frame;

    public InternalFrameLogin(FramePrincipal frame) {
        initComponents();
        this.setTitle("Login");
        setSizeAltentico(btnRegistar, dB);
        setSizeAltentico(btnLogin, dB);
        setSizeAltentico(tfUsuario, dt);
        setSizeAltentico(tfSenha, dt);
        setSizeAltentico(jPanel1, new Dimension(350, 350));
        this.frame = frame;
    }

    public void setSizeAltentico(Component co, Dimension d) {
        co.setSize(d);
        co.setPreferredSize(d);
        co.setMaximumSize(d);
        co.setMinimumSize(d);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        btnRegistar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        tfUsuario = new javax.swing.JTextField();
        btnRecuperarSenha = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(46, 179, 211));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("Usuario*:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(lbUsuario, gridBagConstraints);

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbSenha.setForeground(new java.awt.Color(255, 255, 255));
        lbSenha.setText("Senha*:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(lbSenha, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(tfSenha, gridBagConstraints);

        btnRegistar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistar.setText("Registar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(btnRegistar, gridBagConstraints);

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(btnLogin, gridBagConstraints);

        tfUsuario.setText("Digite o Usuario Aqui");
        tfUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUsuarioFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(tfUsuario, gridBagConstraints);

        btnRecuperarSenha.setBackground(new java.awt.Color(46, 179, 211));
        btnRecuperarSenha.setForeground(new java.awt.Color(255, 0, 0));
        btnRecuperarSenha.setText("Recuperar Senha");
        btnRecuperarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarSenhaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(btnRecuperarSenha, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsuarioFocusGained
        tfUsuario.setText("");
    }//GEN-LAST:event_tfUsuarioFocusGained

    private void tfUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUsuarioFocusLost
        if (tfUsuario.getText().length() == 0) {
            tfUsuario.setText("Digite o Usuario Aqui");
        }
    }//GEN-LAST:event_tfUsuarioFocusLost

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (tfUsuario.getText().equals("") || tfUsuario.getText().equals("Digite o Usuario Aqui")) {
            JOptionPane.showMessageDialog(this, "Digite O Seu Username");
            return;
        }
        if (String.copyValueOf(tfSenha.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Senha Vaziu");
            return;
        }
        try {
            PessoaControl controladorDePessoa = new PessoaControl();
            boolean logado = controladorDePessoa.login(tfUsuario.getText(), String.copyValueOf(tfSenha.getPassword()));
            if (logado) {
                frame.addPanel(new InternalFrameTelaInicial());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro Ao Estabelecer Conexão Com o Banco de Dados");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        frame.addPanel(new InternalFrameCadastrarPessoa());
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnRecuperarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecuperarSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRecuperarSenha;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
