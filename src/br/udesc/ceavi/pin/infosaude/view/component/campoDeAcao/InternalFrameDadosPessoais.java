package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.modelo.Estado;
import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import java.awt.Dimension;

public class InternalFrameDadosPessoais extends javax.swing.JInternalFrame {

    public InternalFrameDadosPessoais(Pessoa pessoa) {
        initComponents();
        jScrollPane1.setMinimumSize(new Dimension(511, 467));
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getSize().width, 650));

        tfNome.setText(pessoa.getNome());
        tfCPF.setText(pessoa.getCpf());
        tfEmail.setText(pessoa.getEndereco().getEmail());
        tfNumeroSUS.setText(pessoa.getNumeroSUS());
        tfRG.setText(pessoa.getRegistroGeral());
        tfTelefone.setText(pessoa.getEndereco().getTelefone());
        tfDataNascimento.setText(pessoa.getDataNascimento().getDate() + "/" + (pessoa.getDataNascimento().getMonth() + 1) + "/" + pessoa.getDataNascimento().getYear());
        tfBairro.setText(pessoa.getEndereco().getBairro());
        tfCEP.setText(pessoa.getEndereco().getCep());
        tfCidade.setText(pessoa.getEndereco().getCidade());
        tfComplemento.setText(pessoa.getEndereco().getComplemento());
        tfRua.setText(pessoa.getEndereco().getRua());
        tfNumero.setText("" + pessoa.getEndereco().getNumero());
        for (int i = 0; i < Sexo.values().length; i++) {
            if (Sexo.values()[i] == pessoa.getSexo()) {
                cbSexo.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < Estado.values().length; i++) {
            if (Estado.values()[i] == pessoa.getEndereco().getEstado()) {
                cbEstado.setSelectedIndex(i);
                break;
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jpDadosPessoais = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        tfCPF = new javax.swing.JFormattedTextField();
        tfDataNascimento = new javax.swing.JFormattedTextField();
        cbSexo = new javax.swing.JComboBox<>();
        tfRG = new javax.swing.JTextField();
        lbRG = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jpDadosEndereco = new javax.swing.JPanel();
        lbCEP = new javax.swing.JLabel();
        lbCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        lbRua = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        lbComplemento = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        lbEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        tfCEP = new javax.swing.JFormattedTextField();
        jpDadosSUS = new javax.swing.JPanel();
        lbNumeroSUS = new javax.swing.JLabel();
        tfNumeroSUS = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(493, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(493, 467));
        jPanel1.setPreferredSize(new java.awt.Dimension(493, 467));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jpDadosPessoais.setPreferredSize(new java.awt.Dimension(569, 245));

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNome.setText("Nome:");

        lbCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCPF.setText("CPF:");

        lbDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDataNascimento.setText("Data de Nascimento");

        lbSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSexo.setText("Sexo:");

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataNascimentoActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        lbRG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbRG.setText("RG");

        lbTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTelefone.setText("Telefone");

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEmail.setText("Email");

        javax.swing.GroupLayout jpDadosPessoaisLayout = new javax.swing.GroupLayout(jpDadosPessoais);
        jpDadosPessoais.setLayout(jpDadosPessoaisLayout);
        jpDadosPessoaisLayout.setHorizontalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome)
                    .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(lbTelefone)
                                .addGap(53, 53, 53)
                                .addComponent(lbEmail))
                            .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDadosPessoaisLayout.createSequentialGroup()
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfEmail))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDadosPessoaisLayout.createSequentialGroup()
                                    .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbCPF))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbRG))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDataNascimento)
                                        .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSexo)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDadosPessoaisLayout.setVerticalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPF)
                    .addComponent(lbRG)
                    .addComponent(lbDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTelefone)
                            .addComponent(lbEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lbSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        jPanel1.add(jpDadosPessoais, gridBagConstraints);

        jpDadosEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        lbCEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCEP.setText("CEP:");

        lbCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCidade.setText("Cidade:");

        lbRua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbRua.setText("Rua:");

        lbComplemento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbComplemento.setText("Complemento:");

        lbNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNumero.setText("Numero:");

        lbBairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbBairro.setText("Bairro:");

        lbEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEstado.setText("Estado:");

        cbEstado.removeAllItems();
        for(int i = 0; i< Estado.values().length; i++){
            cbEstado.addItem(Estado.values()[i].toString());
        }
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpDadosEnderecoLayout = new javax.swing.GroupLayout(jpDadosEndereco);
        jpDadosEndereco.setLayout(jpDadosEnderecoLayout);
        jpDadosEnderecoLayout.setHorizontalGroup(
            jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                        .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                        .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                        .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCEP)
                            .addComponent(lbCidade)
                            .addComponent(lbRua)
                            .addComponent(lbComplemento)
                            .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                                        .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbEstado)
                                            .addComponent(lbBairro))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jpDadosEnderecoLayout.setVerticalGroup(
            jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCEP)
                    .addComponent(lbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCidade)
                    .addComponent(lbBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(lbNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbComplemento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        jPanel1.add(jpDadosEndereco, gridBagConstraints);

        jpDadosSUS.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de SUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        lbNumeroSUS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNumeroSUS.setText("Numero do SUS");

        javax.swing.GroupLayout jpDadosSUSLayout = new javax.swing.GroupLayout(jpDadosSUS);
        jpDadosSUS.setLayout(jpDadosSUSLayout);
        jpDadosSUSLayout.setHorizontalGroup(
            jpDadosSUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosSUSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDadosSUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNumeroSUS)
                    .addComponent(tfNumeroSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jpDadosSUSLayout.setVerticalGroup(
            jpDadosSUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosSUSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNumeroSUS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfNumeroSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        jPanel1.add(jpDadosSUS, gridBagConstraints);

        btAlterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAlterar.setText("Salvar Alterações");
        jPanel2.add(btAlterar);

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancelar.setText("Cancelar");
        jPanel2.add(btCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(jPanel2, gridBagConstraints);

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

    private void tfDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataNascimentoActionPerformed
    }//GEN-LAST:event_tfDataNascimentoActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpDadosEndereco;
    private javax.swing.JPanel jpDadosPessoais;
    private javax.swing.JPanel jpDadosSUS;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCEP;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbNumeroSUS;
    private javax.swing.JLabel lbRG;
    private javax.swing.JLabel lbRua;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JFormattedTextField tfDataNascimento;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfNumeroSUS;
    private javax.swing.JTextField tfRG;
    private javax.swing.JTextField tfRua;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
