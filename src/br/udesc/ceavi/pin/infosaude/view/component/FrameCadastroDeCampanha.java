package br.udesc.ceavi.pin.infosaude.view.component;

import br.udesc.ceavi.pin.infosaude.control.excecpton.IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class FrameCadastroDeCampanha extends javax.swing.JFrame {

    private int aux = 0;
    private List<Vacina> date;

    public FrameCadastroDeCampanha() throws IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException {
        initComponents();
        Dimension d = new Dimension(300, 275);
        this.jpVacina.setSize(d);
        this.jpVacina.setPreferredSize(d);
        this.jpVacina.setMaximumSize(new Dimension(d.getSize().width, 400));
        date = new ArrayList<>();
        List<PublicoAlvo> listP = new ArrayList<>();
        listP.add(new PublicoAlvo(50, 30, Sexo.M));
        listP.add(new PublicoAlvo(50, 30, Sexo.F));
        listP.add(new PublicoAlvo(15, 10, Sexo.F));
        listP.add(new PublicoAlvo(15, 10, Sexo.F));
        date.add(new Vacina(1, "Tetano", listP));
        date.add(new Vacina(1, "HPV", listP));
        date.add(new Vacina(2, "Gripe Suina", listP));
        listaVacina();
    }

    //Alimenta o frame com as vacina
    public void listaVacina() {
        cbVacina.removeAllItems();
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
        List<PublicoAlvo> publico = date.get(cbVacina.getSelectedIndex()).getPublicosAlvos();
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
        JLabel elem = new JLabel((aux +1) + " -  ");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                    .addComponent(jLabel5)
                    .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfSlogn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpVacina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(cbVacina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(cbVacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpVacina, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(tfSlogn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrar)
                            .addComponent(btnLimpar))
                        .addGap(40, 40, 40))))
        );

        GridBagLayout jpMenuLayout = (GridBagLayout) this.jpVacina.getLayout();
        jpMenuLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        jpMenuLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        setSize(new java.awt.Dimension(602, 369));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
                try {
                    new FrameCadastroDeCampanha().setVisible(true);
                } catch (IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException ex) {
                    Logger.getLogger(FrameCadastroDeCampanha.class.getName()).log(Level.SEVERE, null, ex);
                }
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
