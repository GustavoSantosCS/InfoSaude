/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoJDBC;
import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class PessoaControl {

    private final ConexaoPostgresJDBC conexao;

    public PessoaControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(Pessoa pessoa,Endereco endereco) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into pessoa(id_endereco,nome,login,senha,cpf,rg,numero_sus,data_nascimento,sexo) values(?,?,?,?,?,?,?,?)returning id_pessoa";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, endereco.getId());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getLogin());
            stmt.setString(4, pessoa.getSenha());
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, pessoa.getRegistroGeral());
            stmt.setString(7, pessoa.getNumeroSUS());
            stmt.setDate(8, (Date) pessoa.getDataNascimento());
            stmt.setString(9, pessoa.getSexo().toString());
            
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
