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

    public Long inserir(Profissional profissional, Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "insert into profissional(id_instituicao) values(?)returning id_pessoa";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, instituicao.getId());

            ResultSet rs = stmt.executeQuery();
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
}
