package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class InternalFrameVacina extends javax.swing.JInternalFrame {

    public InternalFrameVacina() {
        initComponents();
        this.setTitle("Tela de Vacinas");
    }

    public void addVacina(Vacina vacina) {
        JPanel panel = new JPanel();
        GridBagConstraints cons = new GridBagConstraints();
        panel.setSize(new Dimension(200, 200));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new LineBorder(Color.BLUE, 1));

        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.CENTER;
        cons.gridwidth = 2;
        panel.add(new Label("Vacina da " + vacina.getVacina()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        panel.add(new Label("Doença:"), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        panel.add(new Label(" " + vacina.getVacina()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        panel.add(new Label("Profissional Que Aplicou:"), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 2;
        panel.add(new Label(" " + vacina.getProfissional().getNome()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 2;
        panel.add(new Label("Data: " + vacina.getDataAplicacao().getDay()
                + "/" + vacina.getDataAplicacao().getMonth()
                + "/" + vacina.getDataAplicacao().getYear()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 2;
        panel.add(new Label("Observações:"), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 7;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField("Observações Aquiv"), cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        panel.add(new Label("Dose:"), cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        panel.add(new Label(" " + vacina.getDose()), cons);

        cons = new GridBagConstraints();
        cons.gridx = jpVacina.getComponentCount() % 3;
        cons.gridy = jpVacina.getComponentCount() / 3;
        cons.insets = new Insets(5, 5, 5, 5);
        cons.weightx = 1.0;
        cons.fill = GridBagConstraints.BOTH;
        this.jpVacina.add(panel, cons);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jpVacina = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnTomada = new javax.swing.JButton();
        btnNaoTomadas = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBackground(new java.awt.Color(46, 179, 211));
        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(null);

        jpVacina.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jpVacina);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnTomada.setText("Tomadas");
        btnTomada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomadaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTomada);

        btnNaoTomadas.setText("Não Tomadas");
        btnNaoTomadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoTomadasActionPerformed(evt);
            }
        });
        jPanel1.add(btnNaoTomadas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTomadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTomadaActionPerformed

    private void btnNaoTomadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoTomadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNaoTomadasActionPerformed

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InternalFrameVacina other = (InternalFrameVacina) obj;
        if (!Objects.equals(this.btnNaoTomadas, other.btnNaoTomadas)) {
            return false;
        }
        if (!Objects.equals(this.btnTomada, other.btnTomada)) {
            return false;
        }
        if (!Objects.equals(this.jPanel1, other.jPanel1)) {
            return false;
        }
        if (!Objects.equals(this.jScrollPane1, other.jScrollPane1)) {
            return false;
        }
        if (!Objects.equals(this.jpVacina, other.jpVacina)) {
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNaoTomadas;
    private javax.swing.JButton btnTomada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpVacina;
    // End of variables declaration//GEN-END:variables
}
