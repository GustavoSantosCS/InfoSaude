package br.udesc.ceavi.pin.infosaude.view.component;

import br.udesc.ceavi.pin.infosaude.control.CampanhaControl;
import br.udesc.ceavi.pin.infosaude.control.VacinaControl;
import br.udesc.ceavi.pin.infosaude.modelo.Campanha;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameCadastroDeCampanha extends javax.swing.JFrame {

    private CampanhaControl campanhaControl;
    private Campanha campanha;
    private VacinaControl vacinaControl;
    private int aux = 0;
    private List<Vacina> date;

    public FrameCadastroDeCampanha() {
        initComponents();
        Dimension d = new Dimension(300, 275);
        this.jpVacina.setSize(d);
        this.jpVacina.setPreferredSize(d);
        this.jpVacina.setMaximumSize(new Dimension(d.getSize().width, 400));
        date = new ArrayList<>();
        List<PublicoAlvo> listP = new ArrayList<>();
        try {
            vacinaControl = new VacinaControl();
            date = vacinaControl.getVacinas();
            for (int i = 0; i < date.size(); i++) {
                date.get(i).setPublicosAlvos(vacinaControl.obterPublicoAlvo(date.get(i).getId()));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro no Sistema! erro ao comunicar com o Banco de Dados");
        }

        listaVacina();
    }

    //Alimenta o frame com as vacina
    public void listaVacina() {
        cbVacina.removeAllItems();
        cbVacina.addItem("Seleciona A Vacina");
        for (int i = 0; i < date.size(); i++) {
            cbVacina.addItem(date.get(i).getVacina());
            cbVacina.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    actionListenerComboBoxVacina(evt);
                }
            });
        }
    }

    private void actionListenerComboBoxVacina(ActionEvent evt) {
        jpVacina.removeAll();
        aux = -1;
        List<PublicoAlvo> publico = date.get(cbVacina.getSelectedIndex() - 1).getPublicosAlvos();
        System.out.println(publico.size());
        for (int i = 0; i < publico.size(); i++) {
            addPublicoAlvo(publico.get(i));
        }
    }

    //Alimenta o com
    public void addPublicoAlvo(PublicoAlvo p) {

        GridBagConstraints cons;
        aux++;

        JLabel lbSexo = new JLabel();
        JLabel jcSexo = new JLabel();
        JLabel lbIdadeDe = new JLabel();
        JLabel idadeMinima = new JLabel("" + p.getMinIdade());
        JLabel lbIdadeAte = new JLabel();
        JLabel idadeMaxima = new JLabel("" + p.getMaxIdade());
        JLabel elem = new JLabel((aux + 1) + " -  ");

        lbSexo.setFont(new Font("Tahoma", 0, 14));
        jcSexo.setFont(new Font("Tahoma", 0, 14));
        lbIdadeDe.setFont(new Font("Tahoma", 0, 14));
        idadeMaxima.setFont(new Font("Tahoma", 0, 14));
        idadeMinima.setFont(new Font("Tahoma", 0, 14));
        lbIdadeAte.setFont(new Font("Tahoma", 0, 14));
        elem.setFont(new Font("Tahoma", 1, 14));

        lbSexo.setText("Sexo: ");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        jpVacina.add(elem, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        jpVacina.add(lbSexo, cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        if (p.getSexo() == Sexo.M) {
            jcSexo.setText("Maculino");
        } else {
            jcSexo.setText("Feminino");
        }
        jpVacina.add(jcSexo, cons);

        lbIdadeDe.setText(" Idade de: ");
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        jpVacina.add(lbIdadeDe, cons);

        cons = new GridBagConstraints();
        cons.gridx = 4;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        jpVacina.add(idadeMinima, cons);

        lbIdadeAte.setText(" Até ");
        cons = new GridBagConstraints();
        cons.gridx = 5;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        jpVacina.add(lbIdadeAte, cons);

        cons = new GridBagConstraints();
        cons.gridx = 6;
        cons.gridy = aux;
        cons.insets = new Insets(5, 0, 5, 0);
        jpVacina.add(idadeMaxima, cons);
        jpVacina.revalidate();
        jpVacina.repaint();
    }

    /**
     * date = getPublicoAlvos(); for (int i = 0; i < date.size(); i++) {
     * System.out.println(date.get(i).toString()); }
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jpVacina = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbVacina = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tfSlogn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfDataInicio = new javax.swing.JFormattedTextField();
        tfDataFim = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("InfoSaúde - Cadastro de Campanha");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nome Da Vacina:*");

        btnLimpar.setText("Limpar Campos");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jpVacina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpVacina.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jpVacina.add(jPanel1, gridBagConstraints);

        cbVacina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbVacina.setSelectedIndex(-1);
        cbVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVacinaActionPerformed(evt);
            }
        });

        jLabel4.setText("Slogan:*");

        jLabel5.setText("Data Inicio:*");

        jLabel6.setText("Data Fim:*");

        tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        tfDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(tfSlogn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(64, 64, 64)
                            .addComponent(cbVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jpVacina, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(tfSlogn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cbVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addGap(30, 30, 30))
        );

        GridBagLayout jpMenuLayout = (GridBagLayout) this.jpVacina.getLayout();
        jpMenuLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        jpMenuLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        setSize(new java.awt.Dimension(602, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     public boolean validarCampos(String slogan, Date dataInicio, Date dataFim){
        boolean a = true;
        
        if(slogan.equals("")){
            a = false;
            JOptionPane.showMessageDialog(null,"INSIRA UM SLOGAN PARA A CAMPANHA");
        }
        if(dataInicio.getDay() > dataFim.getDay()){
            a = false;
            JOptionPane.showMessageDialog(null,"DADO INVALIDO! DATA INSERIDA INVALIDA \nDIA NÃO CONSISTE!");
        }
        if(dataInicio.getMonth()> dataFim.getMonth()){
            a = false;
            JOptionPane.showMessageDialog(null,"DADO INVALIDO! DATA INSERIDA INVALIDA \nMÊS NÃO CONSISTE!");
        }
        if(dataInicio.getYear() > dataFim.getYear()){
            a = false;
            JOptionPane.showMessageDialog(null,"DADO INVALIDO! DATA INSERIDA INVALIDA \nANO NÃO CONSISTE!");
        }
        
        return a;
    }
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String slogan = tfSlogn.getText();
        String[] da = tfDataInicio.getText().split("/");
        Date dataInicio = new Date(Integer.getInteger(da[2]), Integer.getInteger(da[1]), Integer.getInteger(da[0]));
        da = tfDataFim.getText().split("/");
        Date dataFim = new Date(Integer.getInteger(da[2]),Integer.getInteger(da[1]),Integer.getInteger(da[0]));
        Vacina vacina = date.get(cbVacina.getSelectedIndex());
        
        campanha = new Campanha(slogan, vacina, dataInicio, dataFim);
        boolean a = validarCampos(slogan, dataInicio, dataFim);
        
        
        if(a == false){
            JOptionPane.showMessageDialog(null, "DADOS INVALIDOS");
        }else{
//            campanhaControl.inserir(campanha, instituicao, vacina);
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cbVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVacinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVacinaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeCampanha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeCampanha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeCampanha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeCampanha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastroDeCampanha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbVacina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpVacina;
    private javax.swing.JFormattedTextField tfDataFim;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JTextField tfSlogn;
    // End of variables declaration//GEN-END:variables
}
