package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class UsuarioControl {

    private final ConexaoPostgresJDBC conexao;

    public UsuarioControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(Usuario usuario) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "insert into usuario() values()returning id_pessoa";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery);

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

    /*
    *metodo para inserir vacina em usuario
     */
    public Long inserirVacina() {
        Long id = null;

        return id;
    }
}
