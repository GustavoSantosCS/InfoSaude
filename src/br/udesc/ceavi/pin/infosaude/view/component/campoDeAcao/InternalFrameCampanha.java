package br.udesc.ceavi.pin.infosaude.view.component.campoDeAcao;

import br.udesc.ceavi.pin.infosaude.control.excecpton.IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException;
import br.udesc.ceavi.pin.infosaude.modelo.Campanha;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class InternalFrameCampanha extends javax.swing.JInternalFrame {

    Calendar calendar = Calendar.getInstance();

    public InternalFrameCampanha() {
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.MONTH));
        System.out.println(new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).toString());
        initComponents();
        List<PublicoAlvo> lista = new ArrayList<>();
        try {
            lista.add(new PublicoAlvo(10, 6, Sexo.M));
        lista.add(new PublicoAlvo(10, 6, Sexo.F));
        lista.add(new PublicoAlvo(20, 4, Sexo.M));
        lista.add(new PublicoAlvo(20, 4, Sexo.F));
        lista.add(new PublicoAlvo(100, 60, Sexo.M));
        lista.add(new PublicoAlvo(100, 60, Sexo.F));
        } catch (IdadeMaximaMenorQueIdadeMinimaPublicoAlvoException ex) {
            Logger.getLogger(InternalFrameCampanha.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle("Tela de Campanha");
        for (int i = 0; i < 5; i++) {
            addCampanha(new Campanha("Slogam      " + (i + 1), new Vacina(new Date(2008, 1, 16), 1, "Vacina " + (i + 1), new Profissional(), lista),
                    new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_MONTH)),
                    new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))));
        }
    }

    public void addCampanha(Campanha campanha) {
        JPanel panel = new JPanel();
        GridBagConstraints cons = new GridBagConstraints();
        panel.setSize(new Dimension(300, 250));
        panel.setMaximumSize(new Dimension(500, 250));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new LineBorder(Color.BLUE, 1));

        cons.gridx = 0;
        cons.gridy = 0;
        cons.anchor = GridBagConstraints.CENTER;
        cons.gridwidth = 4;
        panel.add(new Label("Campanha de Vacina da " + campanha.getVacina().getVacina()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 4;
        panel.add(new Label("Slogam: " + campanha.getSlogan()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 3;
        panel.add(new Label("Vacina: " + campanha.getVacina().getVacina()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 5;
        cons.gridy = 2;
        cons.anchor = GridBagConstraints.EAST;
        cons.gridwidth = 1;
        JLabel icon = new JLabel();

        if (calendar.getTime().getTime() < campanha.getDataInicio().getTime()) {
            icon.setIcon(new ImageIcon(getClass().getResource("/br/udesc/ceavi/pin/infosaude/imag/Butao_EmAberto.png")));
        } else {
            icon.setIcon(new ImageIcon(getClass().getResource("/br/udesc/ceavi/pin/infosaude/imag/Butao_Finalizado.png")));
        }
        panel.add(icon, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        panel.add(new Label("Periodo: "), cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        panel.add(new Label(campanha.getDataInicio().getDate() + "/"
                + (campanha.getDataInicio().getMonth() + 1) + "/"
                + campanha.getDataInicio().getYear()), cons);

        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 5;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        panel.add(new Label(" Até "), cons);

        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 5;
        cons.anchor = GridBagConstraints.WEST;
        cons.gridwidth = 1;
        cons.gridheight = 1;
        panel.add(new Label(campanha.getDataFim().getDate() + "/"
                + (campanha.getDataFim().getMonth() + 1) + "/"
                + campanha.getDataFim().getYear()), cons);

        cons = new GridBagConstraints();
        cons.gridx = jpVacina.getComponentCount() % 2;
        cons.gridy = jpVacina.getComponentCount() / 2;
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        final InternalFrameCampanha other = (InternalFrameCampanha) obj;
        if (!Objects.equals(this.calendar, other.calendar)) {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpVacina;
    // End of variables declaration//GEN-END:variables
}
