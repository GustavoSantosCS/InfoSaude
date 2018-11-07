/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control.dao;

import java.sql.Connection;
import java.sql.SQLException;

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
public interface ConexaoJDBC {
    
    public Connection getConnection();
    
    public void close();
    
    public void commit()throws SQLException;
    
    public void rollback();
}
