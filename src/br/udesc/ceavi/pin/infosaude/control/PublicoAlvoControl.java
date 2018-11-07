/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class PublicoAlvoControl {
    private final ConexaoPostgresJDBC conexao;

    public PublicoAlvoControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(PublicoAlvo publicoAlvo) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into publicoAlvo(min_idade,max_idade,sexo) values(?,?,?)returning id_publicoAlvo";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setInt(1, publicoAlvo.getMinIdade());
            stmt.setInt(2, publicoAlvo.getMaxIdade());
            stmt.setString(3, publicoAlvo.getSexo().toString());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id_publicoAlvo");
            }
            
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }
        
        return id;
    }
}
