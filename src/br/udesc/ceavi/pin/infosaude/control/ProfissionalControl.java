package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ProfissionalControl {

    private final ConexaoPostgresJDBC conexao;

    public ProfissionalControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(Profissional profissional, Instituicao instituicao) throws SQLException {
        Long id = null;
        String sqlQuery = "insert into profissional(id_instituicao) values(?)";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, instituicao.getId());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong("id_pessoa");
            }

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

    public Long getAcessoProfissional(String login, String senha) throws SQLException {
        Long id_profissional = -1l;
        String sqlQuery = "select prof.id_profissional from pessoa as p natural inner join profissional as prof where p.login = ? and p.senha = ?";
        PreparedStatement stmt = null;
        int q = -1;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {                
                id_profissional = rs.getLong("id_profissional");
            }
        } catch (SQLException ex) {
            this.conexao.rollback();
            throw ex;
        } finally {
            stmt.close();
            this.conexao.close();
        }
        
        return id_profissional;
    }
}
