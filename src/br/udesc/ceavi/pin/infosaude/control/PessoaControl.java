package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.control.excecpton.LoginJaRegistradoNaBaseDeDadosException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class PessoaControl {

    private final ConexaoPostgresJDBC conexao;

    public PessoaControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public boolean validaCampoLogin(String login) throws SQLException, DadosVaziosExcepitions, LoginJaRegistradoNaBaseDeDadosException {
        boolean a = true;
        if (login.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("LOGIN INVALIDADO!");
        } else {
            String sql = "Select login from pessoa where login = ?";
            PreparedStatement stmt = null;
            try {
                stmt = this.conexao.getConnection().prepareStatement(sql);
                stmt.setString(1, login);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String rsLogin = rs.getString("login");
                    if (login.equals(rsLogin)) {
                        a = false;
                        throw new LoginJaRegistradoNaBaseDeDadosException();
                    }
                }
                this.conexao.commit();
            } catch (SQLException error) {
                this.conexao.rollback();
                throw error;
            } finally {
                stmt.close();
                this.conexao.close();
            }
            return a;
        }

    }

    public boolean validaCampos(String cpf, String login,
            String nome, String numero, String rg, String senha) throws DadosVaziosExcepitions, SQLException {
        boolean a = true;
        if (cpf.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("CPF INVALIDO!");
        }
        if (nome.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("NOME INVALIDADO!");
        }
        if (numero.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("NUMERO DO SUS INVALIDADO!");
        }
        if (rg.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("RG INVALIDADO!");
        }
        if (senha.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("SENHA INVALIDADA!");
        }
        return a;
    }

    public Long inserir(Pessoa pessoa, Endereco endereco) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "insert into pessoa(id_endereco,nome_pessoa,login,senha,cpf,rg,numero_sus,data_nascimento,sexo) values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, endereco.getId());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getLogin());
            stmt.setString(4, pessoa.getSenha());
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, "!2312333");
            stmt.setString(7, pessoa.getNumeroSUS());
            stmt.setDate(8, new Date(pessoa.getDataNascimento().getYear(), pessoa.getDataNascimento().getMonth(), pessoa.getDataNascimento().getDate()));
            stmt.setString(9, pessoa.getSexo().toString());

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

    public int Alterar(Pessoa pessoa) throws SQLException {
        int linhasAlteradas = 0;
        String sql = "update pessoa set nome = ?, login = ?, senha = ?, cpf = ?, rg = ?, numero_sus = ?, data_nascimento = ?, sexo = ?";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sql);

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getLogin());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(3, pessoa.getCpf());
            stmt.setString(4, pessoa.getRegistroGeral());
            stmt.setString(5, pessoa.getNumeroSUS());
            stmt.setDate(8, (Date) pessoa.getDataNascimento());
            stmt.setString(9, pessoa.getSexo().toString());

            linhasAlteradas = stmt.executeUpdate();
            this.conexao.commit();
        } finally {
            stmt.close();
            this.conexao.close();
        }
        return linhasAlteradas;
    }
}
