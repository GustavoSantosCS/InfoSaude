package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class PublicoAlvoControl {

    private final ConexaoPostgresJDBC conexao;

    public PublicoAlvoControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(PublicoAlvo publicoAlvo, long id_vacina) throws SQLException {
        Long id = null;
        String sqlQuery = "insert into publico_alvo(id_vacina,min_idade,max_idade,sexo) values(?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id_vacina);
            stmt.setInt(2, publicoAlvo.getMinIdade());
            stmt.setInt(3, publicoAlvo.getMaxIdade());
            stmt.setString(4, publicoAlvo.getSexo().toString());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong("id_publico_alvo");
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
