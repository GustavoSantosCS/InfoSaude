package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.control.CampanhaControl;
import br.udesc.ceavi.pin.infosaude.control.ProfissionalControl;
import br.udesc.ceavi.pin.infosaude.control.UsuarioControl;
import br.udesc.ceavi.pin.infosaude.control.VacinaControl;
import br.udesc.ceavi.pin.infosaude.modelo.Campanha;
import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import br.udesc.ceavi.pin.infosaude.view.component.FrameCadastroDeVacina;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class InternalFrameLancamentoDeVacina extends javax.swing.JInternalFrame {

    private Long id_vacina = -1l;
    private Long id_usuario = -1l;
    private Long id_campanha = -1l;
    private Long id_profissional = -1l;
    private boolean profissionalValido = false;
    private String profissional;
    private boolean registrarCampanha = false;
    private Vacina vacina = null;

    public InternalFrameLancamentoDeVacina() {
        initComponents();
        jScrollPane1.setMinimumSize(new Dimension(511, 467));
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getSize().width, 850));

        tfSenha.setPreferredSize(new Dimension(200, 27));
        tfProfissional.setPreferredSize(new Dimension(200, 27));
        tfCPF.setPreferredSize(new Dimension(60, 27));
        tfNome_Usuario.setPreferredSize(new Dimension(250, 27));
        tfSlogam_Campanha.setPreferredSize(new Dimension(100, 27));
        tfSenha.setPreferredSize(new Dimension(200, 27));
        tfSenha.setMaximumSize(new Dimension(200, 27));
        tfProfissional.setPreferredSize(new Dimension(200, 27));
        tfProfissional.setMaximumSize(new Dimension(200, 27));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jpUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome_Usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        tfNumSUS = new javax.swing.JTextField();
        btnBuscar_Usuario = new javax.swing.JButton();
        jpDadosCampanha = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSlogam_Campanha = new javax.swing.JTextField();
        btnRemoveCampanha = new javax.swing.JButton();
        btnAddCampanha = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbVacina_Campanha = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbCampanha_PeriodoInicial = new javax.swing.JLabel();
        lbCampanha_PeriodoFinal = new javax.swing.JLabel();
        jpDadosDeAcesso = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfProfissional = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        btnValidar_Profissional = new javax.swing.JButton();
        jpBTN = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jpDadosSus1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tfVacina = new javax.swing.JTextField();
        btnBuscar_Vacina = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbDose = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tfObservacoe_Vacina = new javax.swing.JTextField();
        btnCadastarVacina = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Cadastro de Vacina Na Carteira de Vacinação");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(493, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(493, 467));
        jPanel1.setPreferredSize(new java.awt.Dimension(493, 467));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Nome:");

        tfNome_Usuario.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("CPF:");

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCPFActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Numero do SUS:");

        tfNumSUS.setEditable(false);

        btnBuscar_Usuario.setText("Pesquisar");
        btnBuscar_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_UsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jpUsuarioLayout.createSequentialGroup()
                        .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpUsuarioLayout.createSequentialGroup()
                        .addComponent(tfNumSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnBuscar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(tfNome_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpUsuarioLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNumSUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsuarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar_Usuario)))
                .addGap(20, 20, 20))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        jPanel1.add(jpUsuario, gridBagConstraints);

        jpDadosCampanha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Campanha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Slogam:*");

        tfSlogam_Campanha.setEditable(false);

        btnRemoveCampanha.setText("-");
        btnRemoveCampanha.setEnabled(false);
        btnRemoveCampanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCampanhaActionPerformed(evt);
            }
        });

        btnAddCampanha.setText("+");
        btnAddCampanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCampanhaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Vacina:");

        lbVacina_Campanha.setBackground(new java.awt.Color(255, 0, 102));
        lbVacina_Campanha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Periodo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Até");

        lbCampanha_PeriodoInicial.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        lbCampanha_PeriodoFinal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jpDadosCampanhaLayout = new javax.swing.GroupLayout(jpDadosCampanha);
        jpDadosCampanha.setLayout(jpDadosCampanhaLayout);
        jpDadosCampanhaLayout.setHorizontalGroup(
            jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosCampanhaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbVacina_Campanha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(tfSlogam_Campanha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jpDadosCampanhaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(136, 136, 136)))
                .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosCampanhaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoveCampanha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCampanha)
                        .addGap(30, 30, 30))
                    .addGroup(jpDadosCampanhaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDadosCampanhaLayout.createSequentialGroup()
                                .addComponent(lbCampanha_PeriodoInicial)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10)
                                .addComponent(lbCampanha_PeriodoFinal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosCampanhaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addGap(48, 48, 48)))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        jpDadosCampanhaLayout.setVerticalGroup(
            jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosCampanhaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemoveCampanha)
                        .addComponent(btnAddCampanha))
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addComponent(tfSlogam_Campanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVacina_Campanha)
                    .addComponent(jLabel10)
                    .addComponent(lbCampanha_PeriodoInicial)
                    .addComponent(lbCampanha_PeriodoFinal))
                .addGap(20, 20, 20))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        jPanel1.add(jpDadosCampanha, gridBagConstraints);

        jpDadosDeAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profissional Que Esta Aplicando", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jpDadosDeAcesso.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Login:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jpDadosDeAcesso.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Senha:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jpDadosDeAcesso.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpDadosDeAcesso.add(tfProfissional, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jpDadosDeAcesso.add(tfSenha, gridBagConstraints);

        btnValidar_Profissional.setText("Validar");
        btnValidar_Profissional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidar_ProfissionalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        jpDadosDeAcesso.add(btnValidar_Profissional, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        jPanel1.add(jpDadosDeAcesso, gridBagConstraints);

        jButton4.setText("Cancelar");
        jpBTN.add(jButton4);

        jButton5.setText("Cadastrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jpBTN.add(jButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jpBTN, gridBagConstraints);

        jpDadosSus1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vacina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Vacina:*");

        btnBuscar_Vacina.setText("Pesquisar");
        btnBuscar_Vacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar_VacinaActionPerformed(evt);
            }
        });

        jLabel3.setText("Dose:*");

        cbDose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dose 1", "Dose 2", "Dose 3", "Dose 4", "Dose 5" }));

        jLabel4.setText("Observações:*");

        btnCadastarVacina.setText("Cadastar Vacina");
        btnCadastarVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastarVacinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDadosSus1Layout = new javax.swing.GroupLayout(jpDadosSus1);
        jpDadosSus1.setLayout(jpDadosSus1Layout);
        jpDadosSus1Layout.setHorizontalGroup(
            jpDadosSus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosSus1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpDadosSus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jpDadosSus1Layout.createSequentialGroup()
                        .addComponent(tfVacina, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(btnBuscar_Vacina))
                    .addGroup(jpDadosSus1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(cbDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(tfObservacoe_Vacina))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosSus1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastarVacina)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDadosSus1Layout.setVerticalGroup(
            jpDadosSus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosSus1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addGroup(jpDadosSus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosSus1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tfVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar_Vacina))
                .addGap(12, 12, 12)
                .addGroup(jpDadosSus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosSus1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(cbDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(tfObservacoe_Vacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastarVacina)
                .addGap(20, 20, 20))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        jPanel1.add(jpDadosSus1, gridBagConstraints);

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

    private void btnBuscar_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_UsuarioActionPerformed
        if (tfCPF.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo de CPF Vaziu");
            return;
        }
        Pessoa pessoa = null;
        try {
            UsuarioControl controladorUsuario = new UsuarioControl();
            pessoa = controladorUsuario.buscarPeloCPF(tfCPF.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao Estabelecer Conexão Com O Banco de Dados");
            return;
        }
        if (pessoa != null) {
            id_usuario = pessoa.getId();
            tfNome_Usuario.setText(pessoa.getNome());
            tfNumSUS.setText(pessoa.getNumeroSUS());
        } else {
            JOptionPane.showMessageDialog(this, "Usuario Não Encotrado");
        }
    }//GEN-LAST:event_btnBuscar_UsuarioActionPerformed

    private void btnCadastarVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastarVacinaActionPerformed
        FrameCadastroDeVacina frameCadastroDeVacina = new FrameCadastroDeVacina();
        frameCadastroDeVacina.setVisible(true);
    }//GEN-LAST:event_btnCadastarVacinaActionPerformed


    private void btnBuscar_VacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar_VacinaActionPerformed
        if (tfVacina.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campos de Pesquisa Vaziu");
            return;
        }
        if (vacina != null && vacina.getVacina().equals(tfVacina.getText().equals(""))) {
            return;
        }
        try {
            VacinaControl controladorVacina = new VacinaControl();
            vacina = controladorVacina.getVacinaPeloNome(tfVacina.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao Estabelecer Conexão Com O Banco de Dados");
            return;
        }
        if (vacina != null) {
            id_vacina = vacina.getId();
            cbDose.removeAllItems();
            for (int i = 0; i < vacina.getDose(); i++) {
                cbDose.addItem("Dose " + (i + 1));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vacina Não Encotrada");
        }
    }//GEN-LAST:event_btnBuscar_VacinaActionPerformed

    private Campanha campanha = null;
    private void btnAddCampanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCampanhaActionPerformed
        if (campanha == null) {
            try {
                CampanhaControl controleCampanha = new CampanhaControl();
                campanha = controleCampanha.buscarCampanhaPorIdVacina(id_vacina);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao Estabelecer Conexão Com O Banco de Dados");
                return;
            }
        }
        if (campanha != null) {
            this.btnAddCampanha.setEnabled(false);
            this.btnRemoveCampanha.setEnabled(true);
            registrarCampanha = true;
            tfSlogam_Campanha.setText(campanha.getSlogan());
            lbVacina_Campanha.setText(campanha.getVacina().getVacina());
            lbCampanha_PeriodoInicial.setText(campanha.getDataInicio().getDate() + "/" + (campanha.getDataInicio().getMonth() + 1) + "/"
            );
            lbCampanha_PeriodoFinal.setText(campanha.getDataFim().getDate() + "/" + (campanha.getDataFim().getMonth() + 1) + "/"
            );
        } else {
            this.btnAddCampanha.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Nenhuma Campanha Cadastra Para Essa Vacina");
        }
    }//GEN-LAST:event_btnAddCampanhaActionPerformed

    private void btnRemoveCampanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCampanhaActionPerformed
        this.btnAddCampanha.setEnabled(true);
        this.btnRemoveCampanha.setEnabled(false);
        registrarCampanha = false;
        tfSlogam_Campanha.setText("");
        lbCampanha_PeriodoFinal.setText("");
        lbCampanha_PeriodoInicial.setText("");
        lbVacina_Campanha.setText("");
    }//GEN-LAST:event_btnRemoveCampanhaActionPerformed

    private void btnValidar_ProfissionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidar_ProfissionalActionPerformed
        if (tfProfissional.getText().equals("") || tfSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Campos de Login ou Senha Vaziu");
            return;
        }
        try {
            ProfissionalControl controladorProfissional = new ProfissionalControl();
            id_profissional = controladorProfissional.getAcessoProfissional(tfProfissional.getText(), String.copyValueOf(tfSenha.getPassword()));
            if (id_profissional == -1l) {
                JOptionPane.showMessageDialog(this, "Login ou Senha Incorreto");
            } else {
                profissionalValido = true;
                profissional = tfProfissional.getText();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao Estabelecer Conexão Com O Banco de Dados");
            return;
        }
    }//GEN-LAST:event_btnValidar_ProfissionalActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (id_usuario == -1 || id_vacina == -1 || !profissionalValido) {
            JOptionPane.showMessageDialog(this, "Erro Ao Cadastrar Verifique Os Campos do Formulario");
            return;
        } else {
            //Long id_vacina, Long id_usuario, Long id_campanha,Long id_profissional, int dose, String observacoes
            try {
                VacinaControl controladorVacina = new VacinaControl();
                controladorVacina.aplicarVacina(id_vacina, id_usuario, id_campanha, id_profissional, cbDose.getSelectedIndex() + 1, tfObservacoe_Vacina.getText());
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro Ao Estabelecer Uma Conexão Com O Banco de Dados");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCPFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCampanha;
    private javax.swing.JButton btnBuscar_Usuario;
    private javax.swing.JButton btnBuscar_Vacina;
    private javax.swing.JButton btnCadastarVacina;
    private javax.swing.JButton btnRemoveCampanha;
    private javax.swing.JButton btnValidar_Profissional;
    private javax.swing.JComboBox<String> cbDose;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBTN;
    private javax.swing.JPanel jpDadosCampanha;
    private javax.swing.JPanel jpDadosDeAcesso;
    private javax.swing.JPanel jpDadosSus1;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JLabel lbCampanha_PeriodoFinal;
    private javax.swing.JLabel lbCampanha_PeriodoInicial;
    private javax.swing.JLabel lbVacina_Campanha;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfNome_Usuario;
    private javax.swing.JTextField tfNumSUS;
    private javax.swing.JTextField tfObservacoe_Vacina;
    private javax.swing.JTextField tfProfissional;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfSlogam_Campanha;
    private javax.swing.JTextField tfVacina;
    // End of variables declaration//GEN-END:variables
}
