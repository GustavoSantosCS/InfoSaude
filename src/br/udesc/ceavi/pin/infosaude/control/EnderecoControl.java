/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class EnderecoControl {

    private final ConexaoPostgresJDBC conexao;

    public EnderecoControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public boolean validaCampos(String bairro, String cep, String cidade, int numero, String rua) throws DadosVaziosExcepitions {
        boolean a = true;

        if (bairro.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("BAIRRO INVALIDO!");
        }
        if (cep.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("CEP INVALIDO!");
        }
        if (cidade.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("CIDADE INVALIDO!");
        }
        if (numero == 0) {
            a = false;
            throw new DadosVaziosExcepitions("NUMERO DE RESIDENCIA INVALIDO!");
        }
        if (rua.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("RUA INVALIDA!");
        }

        return a;
    }

    public Long inserir(Endereco endereco) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "insert into endereco(bairro,cep,cidade,complemento,numero,rua,estado,email,telefone) values(?,?,?,?,?,?,?,?,?)returning id_endereco";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, endereco.getBairro());
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getComplemento());
            stmt.setInt(5, endereco.getNumero());
            stmt.setString(6, endereco.getRua());
            stmt.setString(7, endereco.getEstado().toString());
            stmt.setString(8, endereco.getEmail());
            stmt.setString(9, endereco.getTelefone());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getLong("id_endereco");
            }

            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }

        return id;
    }
}
