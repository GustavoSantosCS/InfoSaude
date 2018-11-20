package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.control.EnderecoControl;
import br.udesc.ceavi.pin.infosaude.control.PessoaControl;
import br.udesc.ceavi.pin.infosaude.control.UsuarioControl;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.control.excecpton.LoginJaRegistradoNaBaseDeDadosException;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.modelo.Estado;
import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class InternalFrameCadastrarPessoa extends javax.swing.JInternalFrame {

    private Endereco endereco;
    private Pessoa pessoa;
    private PessoaControl controladorPessoa;
    private EnderecoControl controladorEndereco;
    private String loginValido;

    public InternalFrameCadastrarPessoa() {
        initComponents();
        jScrollPane1.setMinimumSize(new Dimension(511, 467));
        jPanel1.setPreferredSize(new Dimension(jScrollPane1.getSize().width, 950));

        jpDadosPessoais.setMinimumSize(new Dimension(511, 315));
        jpDadosPessoais.setPreferredSize(new Dimension(511, 315));
        jpDadosSus.setMinimumSize(new Dimension(511, 100));
        jpDadosSus.setPreferredSize(new Dimension(511, 100));
        jpEndereco.setMinimumSize(new Dimension(511, 300));
        jpEndereco.setPreferredSize(new Dimension(511, 300));
        jpDadosDeAcesso.setMinimumSize(new Dimension(511, 120));
        jpDadosDeAcesso.setPreferredSize(new Dimension(511, 120));

        tfSenha.setPreferredSize(new Dimension(200, 27));
        tfUsuario.setPreferredSize(new Dimension(200, 27));
        tfCPF.setPreferredSize(new Dimension(60, 27));
        tfNome.setPreferredSize(new Dimension(250, 27));
        tfDataNascimento.setPreferredSize((new Dimension(200, 27)));
        jCSexo.setPreferredSize(new Dimension(100, 27));
        tfSUS.setPreferredSize(new Dimension(100, 27));
        tfSenha.setPreferredSize(new Dimension(200, 27));
        tfSenha.setMaximumSize(new Dimension(200, 27));
        tfUsuario.setPreferredSize(new Dimension(200, 27));
        tfUsuario.setMaximumSize(new Dimension(200, 27));
        jComboBox1.removeAllItems();
        for (int i = 0; i < Estado.values().length; i++) {
            jComboBox1.addItem(Estado.values()[i].toString());
        }

    }

    public String getjPanel1() {
        return jPanel1.getSize().toString();
    }

    public String getRolagemSize() {
        return jScrollPane1.getSize().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jpDadosPessoais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDataNascimento = new javax.swing.JFormattedTextField();
        jCSexo = new javax.swing.JComboBox<>();
        tfTelefone = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfRg = new javax.swing.JTextField();
        jpDadosSus = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSUS = new javax.swing.JTextField();
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
        jLabel15 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Cadastro de Usuario");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(493, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(493, 467));
        jPanel1.setPreferredSize(new java.awt.Dimension(493, 467));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jpDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Nome:*");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("CPF:*");

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Data de Nascimento:*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Sexo:*");

        try {
            tfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Masculino","Feminino"}));

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefoneActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel16.setText("TELEFONE:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("EMAIL:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("RG:*");

        tfRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDadosPessoaisLayout = new javax.swing.GroupLayout(jpDadosPessoais);
        jpDadosPessoais.setLayout(jpDadosPessoaisLayout);
        jpDadosPessoaisLayout.setHorizontalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDadosPessoaisLayout.setVerticalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        jPanel1.add(jpDadosPessoais, gridBagConstraints);

        jpDadosSus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de SUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Numero Do SUS");

        javax.swing.GroupLayout jpDadosSusLayout = new javax.swing.GroupLayout(jpDadosSus);
        jpDadosSus.setLayout(jpDadosSusLayout);
        jpDadosSusLayout.setHorizontalGroup(
            jpDadosSusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosSusLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpDadosSusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tfSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jpDadosSusLayout.setVerticalGroup(
            jpDadosSusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosSusLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addComponent(tfSUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        jPanel1.add(jpDadosSus, gridBagConstraints);

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
        jpDadosDeAcesso.add(tfUsuario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
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

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel15.setText("Para que a opção Cadastrar Seja Liberada Valide o Login");

        javax.swing.GroupLayout jpBTNLayout = new javax.swing.GroupLayout(jpBTN);
        jpBTN.setLayout(jpBTNLayout);
        jpBTNLayout.setHorizontalGroup(
            jpBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(20, 20, 20)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpBTNLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jpBTNLayout.setVerticalGroup(
            jpBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBTNLayout.createSequentialGroup()
                .addGroup(jpBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void btnValidarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarLoginActionPerformed
        String login = tfUsuario.getText();
        try {
            controladorPessoa = new PessoaControl();
            try {
                if (controladorPessoa.validaCampoLogin(login)) {
                    loginValido = login;
                    btnCadastrar.setEnabled(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro no Nosso Sistema de Banco de Dados");
                return;
            } catch (DadosVaziosExcepitions | LoginJaRegistradoNaBaseDeDadosException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro no Nosso Sistema de Banco de Dados1");
            return;
        }
    }//GEN-LAST:event_btnValidarLoginActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //Endereco
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
        // Pessoa
        String nome = tfNome.getText();
        String cpf = tfCPF.getText();
        String numeroSUS = tfSUS.getText();
        String login = tfUsuario.getText();
        String rg = tfRg.getText();
        if (tfDataNascimento.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Data de Nascimento informada de Forma Incoreta");
            return;
        }
        String[] da = tfDataNascimento.getText().split("/");
        String lastCrawlDate = da[2] + "-" + da[1] + "-" + da[0];
        Date data = null;
        try {
            data = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro");
        }
        String senha = tfSenha.getText();
        Sexo sexo = Sexo.values()[jCSexo.getSelectedIndex()];
        System.out.println(data.toString());
        endereco = new Endereco(bairro, cep, cidade, complemento, email, numeroCasa, rua, telefone, estado);
        pessoa = new Pessoa(cpf, data, login, nome, numeroSUS, rg, senha, sexo, endereco);
        if (!loginValido.equals(tfUsuario.getText())) {
            JOptionPane.showMessageDialog(this, "Login Não Validado");
            return;
        }
        try {
            controladorEndereco = new EnderecoControl();
            try {
                controladorEndereco.validaCampos(bairro, cep, cidade, numeroCasa, rua);
                controladorPessoa.validaCampos(cpf, nome, numeroSUS, rg, senha);
            } catch (DadosVaziosExcepitions ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro no Nosso Sistema de Banco de Dados");
                return;
            }
            try {
                controladorEndereco.inserir(endereco);
                controladorPessoa = new PessoaControl();
                controladorPessoa.inserir(pessoa, endereco);
                Usuario usuario = new Usuario(pessoa);
                UsuarioControl controladorUsuario = new UsuarioControl();
                controladorUsuario.inserir(usuario);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
                return;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro no Nosso Sistema de Banco de Dados");
            return;
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void tfRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnValidarLogin;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jCSexo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jpDadosDeAcesso;
    private javax.swing.JPanel jpDadosPessoais;
    private javax.swing.JPanel jpDadosSus;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JFormattedTextField tfDataNascimento;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRg;
    private javax.swing.JTextField tfRua;
    private javax.swing.JTextField tfSUS;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
