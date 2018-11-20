package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class UsuarioControl {

    private final ConexaoPostgresJDBC conexao;

    public UsuarioControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(Usuario usuario) throws SQLException {
        Long id = null;
        String sqlQuery = "insert into usuario(id_pessoa) values(?)";
        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, usuario.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong("id_usuario");
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


    public Pessoa buscarPeloCPF(String cpf_usuario) {
        String sqlQuery = "select u.id_usuario, p.nome_pessoa, p.numero_sus from usuario as u natural inner join pessoa as p where p.cpf = ?";
        PreparedStatement stmt = null;
        Pessoa pessoa = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cpf_usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setId(rs.getLong(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setNumeroSUS(rs.getString(3));
            }
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            error.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
            this.conexao.close();
        }
        return pessoa;
    }
}
