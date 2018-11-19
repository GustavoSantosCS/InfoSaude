package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class InstituicaoControl {

    private final ConexaoPostgresJDBC conexao;

    public InstituicaoControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public boolean validaCampos(String cnpj, String nome, String senha) throws DadosVaziosExcepitions {
        boolean a = true;

        if (cnpj.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("CNPJ INVALIDO!");
        }
        if (nome.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("NOME INVALIDO!");
        }
        if (senha.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("SENHA INVALIDO!");
        }

        return a;
    }

    public Long inserir(Instituicao instituicao, Endereco endereco) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "insert into instituicao(id_endereco,cnpj,nome,senha) values(?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, endereco.getId());
            stmt.setString(2, instituicao.getCnpj());
            stmt.setString(3, instituicao.getNome());
            stmt.setString(4, instituicao.getSenha());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            id = rs.getLong(1);

            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        } finally {
            stmt.close();
            this.conexao.close();
        }
        return id;
    }

}
