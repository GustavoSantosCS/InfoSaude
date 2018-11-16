/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Esta Classe define os atributos de Campanha
 *
 * @author Erick William Henschel
 * @author Fabio Frare
 * @author Gustavo de Carvalho Santos
 * @author Lucas Eduardo Nogueira
 * @author Ricardo José Pinto
 * @version 1.0
 * @since 03/11/2018
 */
public class ConexaoPostgresJDBC {

    private Connection con = null;

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ConexaoPostgresJDBC() throws ClassNotFoundException, SQLException {

            Class.forName("org.postgresql.Driver");

            Properties properties = new Properties();
            properties.put("user", "postgres");
<<<<<<< HEAD
            properties.put("password", "123456");
=======
            properties.put("password", "123");
>>>>>>> d8fae54a1345eaf5facd54a28e31b744170c0d87

            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Infosaude?ApplicationName=Projeto-InfoSaude", properties);
            this.con.setAutoCommit(false);
            JOptionPane.showMessageDialog(null, "Conectado");

    }

    public Connection getConnection() {
        return this.con;

    }

    public void close() {
        if (this.con != null) {
            try {
                this.con.close();
            } catch (SQLException error) {
                Logger.getLogger(ConexaoPostgresJDBC.class.getName()).log(Level.SEVERE, null, error);
            }
        }
    }

    public void commit() throws SQLException {
        this.con.commit();
        this.close();
    }

    public void rollback() {
        if (this.con != null) {
            try {
                this.con.rollback();
            } catch (SQLException error) {
                Logger.getLogger(ConexaoPostgresJDBC.class.getName()).log(Level.SEVERE, null, error);
            } finally {
                this.close();
            }
        }
    }
}
