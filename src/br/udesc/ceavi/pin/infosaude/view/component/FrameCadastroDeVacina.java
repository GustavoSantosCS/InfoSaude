package br.udesc.ceavi.pin.infosaude.view.component;

import br.udesc.ceavi.pin.infosaude.control.PublicoAlvoControl;
import br.udesc.ceavi.pin.infosaude.control.VacinaControl;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.control.excecpton.IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrameCadastroDeVacina extends javax.swing.JFrame {

    private List<PublicoAlvo> datePublicoAlvo;
    private int aux = 0;

    public FrameCadastroDeVacina() {
        initComponents();
        Dimension d = new Dimension(375, 275);
        this.jpVacina.setSize(d);
        this.jpVacina.setPreferredSize(d);
        this.jpVacina.setMaximumSize(new Dimension(d.getSize().width, 400));
        datePublicoAlvo = new ArrayList<>();
    }

    public Sexo getSexo(int index) {
        Sexo S = null;
        if (index == 0) {
            S = Sexo.M;
        }
        if (index == 1) {
            S = Sexo.F;
        }
        return S;
    }

    public List<PublicoAlvo> getPublicoAlvos() {
        int idadeMax = -1;
        int idadeMim = -1;
        int sexo = -1;
        int ponteiro = 0;
        do {
            if (ponteiro < 6) {
                ponteiro++;
                sexo = ((JComboBox) jpVacina.getComponent(ponteiro)).getSelectedIndex();
                ponteiro++;
                ponteiro++;
                idadeMim = (int) ((JSpinner) jpVacina.getComponent(ponteiro)).getValue();
                ponteiro++;
                ponteiro++;
                idadeMax = (int) ((JSpinner) jpVacina.getComponent(ponteiro)).getValue();
                ponteiro++;
                ponteiro++;
            } else {
                ponteiro++;
                System.out.println(ponteiro);
                sexo = ((JComboBox) jpVacina.getComponent(ponteiro)).getSelectedIndex();
                ponteiro++;
                ponteiro++;
                idadeMim = (int) ((JSpinner) jpVacina.getComponent(ponteiro)).getValue();
                ponteiro++;
                ponteiro++;
                idadeMax = (int) ((JSpinner) jpVacina.getComponent(ponteiro)).getValue();
                ponteiro++;
            }
            if (sexo == 2) {
                try {
                    datePublicoAlvo.add(new PublicoAlvo(idadeMax, idadeMim, getSexo(0)));
                    datePublicoAlvo.add(new PublicoAlvo(idadeMax, idadeMim, getSexo(1)));
                } catch (IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else {
                try {
                    datePublicoAlvo.add(new PublicoAlvo(idadeMax, idadeMim, getSexo(sexo)));
                } catch (IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        } while (ponteiro < jpVacina.getComponentCount());
        return datePublicoAlvo;
    }

    public void addPublicoAlvo() {
        btnMenos.setEnabled(true);
        if (aux < 4) {
            GridBagConstraints cons;
            lbSexo = new JLabel();
            jcSexo = new JComboBox<>();
            lbIdadeDe = new JLabel();
            idadeMinima = new JSpinner();
            lbIdadeAte = new JLabel();
            idadeMaxima = new JSpinner();
            aux++;
            lbSexo.setText("Sexo");
            cons = new GridBagConstraints();
            cons.gridx = 0;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(lbSexo, cons);

            jcSexo.setModel(new DefaultComboBoxModel<>(new String[]{"M", "F", "M e F"}));
            cons = new GridBagConstraints();
            cons.gridx = 1;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(jcSexo, cons);

            lbIdadeDe.setText("Idade de");
            cons = new GridBagConstraints();
            cons.gridx = 2;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(lbIdadeDe, cons);

            idadeMinima.setModel(new SpinnerNumberModel(1, 1, 120, 1));
            cons = new GridBagConstraints();
            cons.gridx = 3;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(idadeMinima, cons);

            lbIdadeAte.setText("Até");
            cons = new GridBagConstraints();
            cons.gridx = 4;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(lbIdadeAte, cons);

            idadeMaxima.setModel(new SpinnerNumberModel(1, 1, 120, 1));
            cons = new GridBagConstraints();
            cons.gridx = 5;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(idadeMaxima, cons);

            jpVacina.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Não é possivel Cadastrar Mais Publicos Alvos");
            btnAdd.setEnabled(false);
        }
    }

    /**
     * date = getPublicoAlvos(); for (int i = 0; i < date.size(); i++) {
     * System.out.println(date.get(i).toString()); }
     */
    public void removePublicoAlvo() {
        if (aux != 0) {
            int aux = jpVacina.getComponentCount();
            for (int i = 0; i < 6; i++) {
                jpVacina.remove(jpVacina.getComponentCount() - 1);
            }
            btnAdd.setEnabled(true);
        } else {
            btnMenos.setEnabled(false);
        }
        if (aux > 0) {
            aux--;
        }
        jpVacina.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        tfVacina_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNumDose = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfObservacoes = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jpVacina = new javax.swing.JPanel();
        lbSexo = new javax.swing.JLabel();
        jcSexo = new javax.swing.JComboBox<>();
        lbIdadeDe = new javax.swing.JLabel();
        idadeMinima = new javax.swing.JSpinner();
        lbIdadeAte = new javax.swing.JLabel();
        idadeMaxima = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        btnMenos = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("InfoSaúde - Cadastro de Vacina");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nome Da Vacina:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        tfVacina_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVacina_nomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(tfVacina_nome, gridBagConstraints);

        jLabel2.setText("Numero de Dose:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(tfNumDose, gridBagConstraints);

        jLabel3.setText("Observações");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(tfObservacoes, gridBagConstraints);

        btnLimpar.setText("Limpar Campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnLimpar, gridBagConstraints);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnCadastrar, gridBagConstraints);

        jpVacina.setBorder(javax.swing.BorderFactory.createTitledBorder("Publico Alvo"));
        jpVacina.setLayout(new java.awt.GridBagLayout());

        lbSexo.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jpVacina.add(lbSexo, gridBagConstraints);

        jcSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "M e F" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jpVacina.add(jcSexo, gridBagConstraints);

        lbIdadeDe.setText("Idade de");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jpVacina.add(lbIdadeDe, gridBagConstraints);

        idadeMinima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jpVacina.add(idadeMinima, gridBagConstraints);

        lbIdadeAte.setText("Até");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jpVacina.add(lbIdadeAte, gridBagConstraints);

        idadeMaxima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        jpVacina.add(idadeMaxima, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnMenos.setText("-");
        btnMenos.setEnabled(false);
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(btnMenos, gridBagConstraints);

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(btnAdd, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jpVacina.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        getContentPane().add(jpVacina, gridBagConstraints);
        GridBagLayout jpMenuLayout = (GridBagLayout) this.jpVacina.getLayout();
        jpMenuLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        jpMenuLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

        setSize(new java.awt.Dimension(720, 335));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addPublicoAlvo();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        removePublicoAlvo();
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        getPublicoAlvos();
        long id_vacina = -1;
        for (int i = 0; i < datePublicoAlvo.size(); i++) {
            System.out.println(datePublicoAlvo.get(i).toString());
        }
        try {
            VacinaControl controladorVacina = new VacinaControl();
            try {
                int dose = 0;
                if (!tfNumDose.getText().equals("")) {
                    dose = Integer.valueOf(tfNumDose.getText());
                    if (controladorVacina.validarVacina(dose, tfVacina_nome.getText())) {
                        id_vacina = controladorVacina.inserir(dose, tfVacina_nome.getText(), tfObservacoes.getText());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Numero De Dose Não Informado");
                }
            } catch (DadosVaziosExcepitions ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na Coneção com Banco");
        }
        try {
            PublicoAlvoControl controladorPublicoAlvo = new PublicoAlvoControl();
            for (int i = 0; i < datePublicoAlvo.size(); i++) {
                controladorPublicoAlvo.inserir(datePublicoAlvo.get(i), id_vacina);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro na Coneção com Banco");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        tfNumDose.setText("");
        tfObservacoes.setText("");
        tfVacina_nome.setName("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tfVacina_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVacina_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfVacina_nomeActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCadastroDeVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroDeVacina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastroDeVacina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnMenos;
    private javax.swing.JSpinner idadeMaxima;
    private javax.swing.JSpinner idadeMinima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcSexo;
    private javax.swing.JPanel jpVacina;
    private javax.swing.JLabel lbIdadeAte;
    private javax.swing.JLabel lbIdadeDe;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JTextField tfNumDose;
    private javax.swing.JTextField tfObservacoes;
    private javax.swing.JTextField tfVacina_nome;
    // End of variables declaration//GEN-END:variables
}
