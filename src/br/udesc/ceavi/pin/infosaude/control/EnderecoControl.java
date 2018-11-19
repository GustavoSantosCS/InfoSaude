package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        String sqlQuery = "insert into endereco(bairro,cep,cidade,complemento,numero,rua,estado,email,telefone) values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getBairro());
            stmt.setString(2, endereco.getCep());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getComplemento());
            stmt.setInt(5, endereco.getNumero());
            stmt.setString(6, endereco.getRua());
            String e = endereco.getEstado().toString();
            e = e.replaceAll(" ", "_");
            stmt.setString(7, e.toUpperCase());
            stmt.setString(8, "GustavoSantosixi@gmail.com");
            stmt.setString(9, "47 991518293");
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                endereco.setId(rs.getLong(1));
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
