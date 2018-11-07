/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class ProfissionalControl {
    private final ConexaoPostgresJDBC conexao;

    public ProfissionalControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(Profissional profissional,Instituicao instituicao) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into profissional(id_instituicao) values(?)returning id_pessoa";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, instituicao.getId());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id_pessoa");
            }
            
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }
        
        return id;
    }
}
