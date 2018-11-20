package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.control.EnderecoControl;
import br.udesc.ceavi.pin.infosaude.control.InstituicaoControl;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.modelo.Estado;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class InternalFrameCadastrarInstituicao extends javax.swing.JInternalFrame {

    private Endereco endereco;
    private EnderecoControl enderecoControl;
    private Instituicao instituicao;
    private InstituicaoControl instituicaoControl;

    /**
     * Creates new form InternalFrameInstituicao
     */
    public InternalFrameCadastrarInstituicao() {
        initComponents();
        this.setTitle("Cadastro de Instuição");
        jScrollPane1.setMinimumSize(new Dimension(511, 467));
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getSize().width, 850));

        tfSenha.setPreferredSize(new Dimension(200, 27));
        tfUsuario.setPreferredSize(new Dimension(200, 27));
        tfNome.setPreferredSize(new Dimension(250, 27));
        tfCNPJ.setPreferredSize((new Dimension(200, 27)));
        tfSenha.setPreferredSize(new Dimension(200, 27));
        tfSenha.setMaximumSize(new Dimension(200, 27));
        tfUsuario.setPreferredSize(new Dimension(200, 27));
        tfUsuario.setMaximumSize(new Dimension(200, 27));
        jComboBox1.removeAllItems();
        for (int i = 0; i < Estado.values().length; i++) {
            jComboBox1.addItem(Estado.values()[i].toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jpDadosIntituicao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfCNPJ = new javax.swing.JFormattedTextField();
        btnValidarCNPJ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jpEndereco = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfRua = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        tfComplemento = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jpDadosDeAcesso = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        btnValidarLogin = new javax.swing.JButton();
        jpBTN = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(493, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(493, 467));
        jPanel1.setPreferredSize(new java.awt.Dimension(493, 467));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpDadosIntituicao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Instituição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jpDadosIntituicao.setMaximumSize(new java.awt.Dimension(32767, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Nome:*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("CNPJ:*");

        try {
            tfCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnValidarCNPJ.setText("Validar CNPJ");
        btnValidarCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarCNPJActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("TELEFONE:");

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("EMAIL:");

        javax.swing.GroupLayout jpDadosIntituicaoLayout = new javax.swing.GroupLayout(jpDadosIntituicao);
        jpDadosIntituicao.setLayout(jpDadosIntituicaoLayout);
        jpDadosIntituicaoLayout.setHorizontalGroup(
            jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosIntituicaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDadosIntituicaoLayout.createSequentialGroup()
                        .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfCNPJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addGap(157, 157, 157)
                        .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(btnValidarCNPJ)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDadosIntituicaoLayout.setVerticalGroup(
            jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosIntituicaoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidarCNPJ))
                .addGap(18, 18, 18)
                .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosIntituicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        jPanel1.add(jpDadosIntituicao, gridBagConstraints);

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados De Endereco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel8.setText("Cep:*");

        jLabel9.setText("Cidade:*");

        jLabel10.setText("Rua:*");

        jLabel11.setText("Complemento:*");

        jLabel12.setText("Estado:*");

        jLabel13.setText("Bairro:*");

        jLabel14.setText("Numero:*");

        tfCEP.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        tfCEP.setPreferredSize(new java.awt.Dimension(69, 24));

        tfCidade.setMaximumSize(new java.awt.Dimension(2147483647, 24));
        tfCidade.setPreferredSize(new java.awt.Dimension(69, 24));
        tfCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCidadeActionPerformed(evt);
            }
        });

        tfBairro.setMaximumSize(new java.awt.Dimension(120, 24));
        tfBairro.setMinimumSize(new java.awt.Dimension(120, 22));
        tfBairro.setPreferredSize(new java.awt.Dimension(120, 24));

        tfRua.setMaximumSize(new java.awt.Dimension(400, 24));
        tfRua.setMinimumSize(new java.awt.Dimension(300, 24));
        tfRua.setPreferredSize(new java.awt.Dimension(300, 24));

        tfNumero.setMaximumSize(new java.awt.Dimension(45, 24));
        tfNumero.setMinimumSize(new java.awt.Dimension(45, 24));
        tfNumero.setPreferredSize(new java.awt.Dimension(45, 24));

        tfComplemento.setMaximumSize(new java.awt.Dimension(450, 24));
        tfComplemento.setMinimumSize(new java.awt.Dimension(300, 24));
        tfComplemento.setPreferredSize(new java.awt.Dimension(300, 24));

        jComboBox1.setMaximumSize(new java.awt.Dimension(120, 22));
        jComboBox1.setMinimumSize(new java.awt.Dimension(120, 22));
        jComboBox1.setPreferredSize(new java.awt.Dimension(120, 22));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jpEnderecoLayout.createSequentialGroup()
                            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpEnderecoLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnderecoLayout.createSequentialGroup()
                                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)))
                            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpEnderecoLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel14)))
                        .addGroup(jpEnderecoLayout.createSequentialGroup()
                            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnderecoLayout.createSequentialGroup()
                                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnderecoLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(227, 227, 227)))
                            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13)
                                .addComponent(tfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8)
                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnderecoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)))
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnderecoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(10, 10, 10)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addGap(10, 10, 10)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        jPanel1.add(jpEndereco, gridBagConstraints);

        jpDadosDeAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados De Acesso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jpDadosDeAcesso.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Login:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jpDadosDeAcesso.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Senha:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jpDadosDeAcesso.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 144;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jpDadosDeAcesso.add(tfUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 144;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jpDadosDeAcesso.add(tfSenha, gridBagConstraints);

        btnValidarLogin.setText("Validar");
        btnValidarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jpDadosDeAcesso.add(btnValidarLogin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        jPanel1.add(jpDadosDeAcesso, gridBagConstraints);

        jButton4.setText("Cancelar");
        jpBTN.add(jButton4);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jpBTN.add(btnCadastrar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jpBTN, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCidadeActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // Endereco
        String bairro = tfBairro.getText();

        String cep = tfCEP.getText();
        String cidade = tfCidade.getText();
        String complemento = tfComplemento.getText();
        if (tfNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe o Numero");
            return;
        }
        int numeroCasa = Integer.parseInt(tfNumero.getText());
        String rua = tfRua.getText();
        Estado estado = Estado.values()[jComboBox1.getSelectedIndex()];
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        //Instituicao
        String cnpj = tfCNPJ.getText();
        String nome = tfNome.getText();
        String senha = String.copyValueOf(tfSenha.getPassword());

        endereco = new Endereco(bairro, cep, cidade, complemento, email, numeroCasa, rua, telefone, estado);
        instituicao = new Instituicao(cnpj, nome, senha, endereco);
        boolean b = false;
        boolean a = false;

        try {
            enderecoControl = new EnderecoControl();
            enderecoControl.validaCampos(bairro, cep, cidade, numeroCasa, rua);
            instituicaoControl = new InstituicaoControl();
            instituicaoControl.validaCampos(cnpj, nome, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InternalFrameCadastrarInstituicao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DadosVaziosExcepitions ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        try {
            enderecoControl = new EnderecoControl();
            instituicaoControl = new InstituicaoControl();
            enderecoControl.inserir(endereco);
            instituicaoControl.inserir(instituicao, endereco);
            JOptionPane.showMessageDialog(this, "Cadastro Realizado Com Sucesso");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na Conexão com o Banco de Dados");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnValidarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarLoginActionPerformed

    }//GEN-LAST:event_btnValidarLoginActionPerformed

    private void btnValidarCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarCNPJActionPerformed

    }//GEN-LAST:event_btnValidarCNPJActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnValidarCNPJ;
    private javax.swing.JButton btnValidarLogin;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBTN;
    private javax.swing.JPanel jpDadosDeAcesso;
    private javax.swing.JPanel jpDadosIntituicao;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JFormattedTextField tfCNPJ;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
