package br.udesc.ceavi.pin.infosaude.view.component;

import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrameCadastroDeVacina extends javax.swing.JFrame {

    private List<PublicoAlvo> date;

    public FrameCadastroDeVacina() {
        initComponents();
        System.out.println(this.getSize());
        Dimension d = new Dimension(375, 275);

        this.jpVacina.setSize(d);
        this.jpVacina.setPreferredSize(d);
        this.jpVacina.setMaximumSize(new Dimension(d.getSize().width, 400));

    }

    int aux = 0;

    public void addPublicoAlvo() {
        if (aux < 4) {
            GridBagConstraints cons;
            lbSexo = new JLabel();
            jcSexo = new JComboBox<>();
            lbIdadeDe = new JLabel();
            idadeMinima = new JSpinner();
            lbIdadeAte = new JLabel();
            idadeMaxima = new JSpinner();
            btnAdd = new JButton();
            btnMenos = new JButton();
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

            btnAdd.setText("+");
            btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnAddActionPerformed(evt);
                }
            });
            cons = new GridBagConstraints();
            cons.gridx = 6;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(btnAdd, cons);

            btnMenos.setText("-");
            cons = new GridBagConstraints();
            cons.gridx = 7;
            cons.gridy = aux;
            cons.insets = new Insets(5, 0, 5, 0);
            jpVacina.add(btnMenos, cons);
            jpVacina.repaint();
        } else {
            int e = 7;
            int a = 2;
            JOptionPane.showMessageDialog(this, "Não é possivel Cadastrar Mais Publicos Alvos");
            for (int i = 0; i < jpVacina.getComponentCount(); i++) {
                if (i == e - 1) {
                    System.out.println(i);
                    jpVacina.getComponent(i).setEnabled(false);
                    e = (7 * (a++ + 1) - i) - 1;
                    System.out.println(e);
                }
            }
        }
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
        btnAdd = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InfoSaúde - Cadastro de Vacina");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nome Da Vacina:*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnLimpar, gridBagConstraints);

        btnCadastrar.setText("Cadastrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(btnCadastrar, gridBagConstraints);

        jpVacina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpVacina.setLayout(new java.awt.GridBagLayout());

        lbSexo.setText("Sexo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(lbSexo, gridBagConstraints);

        jcSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "M e F" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(jcSexo, gridBagConstraints);

        lbIdadeDe.setText("Idade de");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(lbIdadeDe, gridBagConstraints);

        idadeMinima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(idadeMinima, gridBagConstraints);

        lbIdadeAte.setText("Até");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(lbIdadeAte, gridBagConstraints);

        idadeMaxima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(idadeMaxima, gridBagConstraints);

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(btnAdd, gridBagConstraints);

        btnMenos.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jpVacina.add(btnMenos, gridBagConstraints);

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
