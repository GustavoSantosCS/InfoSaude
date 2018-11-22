package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.control.excecpton.LoginJaRegistradoNaBaseDeDadosException;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario;
import br.udesc.ceavi.pin.infosaude.modelo.Usuario_Logado;
import br.udesc.ceavi.pin.infosaude.principal.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                    }
                }
                if (this.conexao != null) {
                    this.conexao.close();
                }
            }
            return a;
        }
    }

    public boolean validaCampos(String cpf,
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

    public Long inserir(Pessoa pessoa, Endereco endereco) throws SQLException {
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
            stmt.setString(6, pessoa.getRegistroGeral());
            stmt.setString(7, pessoa.getNumeroSUS());
            java.sql.Date dataN = new java.sql.Date(pessoa.getDataNascimento().getTime());
            stmt.setDate(8, dataN);
            stmt.setString(9, pessoa.getSexo().toString());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            pessoa.setId(id);
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (this.conexao != null) {
                this.conexao.close();
            }
        }

        return id;
    }


    public boolean login(String login, String senha) throws SQLException {
        String sqlUsuario = "select * from pessoa as p natural inner join usario where p.login = ? and p.senha = ?";
        String sqlProfissional = "select * from pessoa as p natural inner join usario where p.login = ? and p.senha = ?";
        String sqlInstuicao = "select * from instituicao as i where i.cnpj = ? and p.senha = ?";
        boolean usuarioEncontrado = false;
        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlUsuario);
            stmt.setString(1, login);
            stmt.setString(2, login);
            ResultSet rs = stmt.executeQuery();
            Usuario_Logado p = null;
            while (rs.next()) {
                Long id_pessoa = rs.getLong(1);
                if (id_pessoa != null) {
                    p = new Usuario(id_pessoa,
                            rs.getLong("id_usuario"),
                            rs.getString("cpf"),
                            new Date(rs.getString("data_nascimento")),
                            rs.getString("login"),
                            rs.getString("nome"),
                            rs.getString("numero_sus"),
                            rs.getString("rg"),
                            rs.getString("senha"),
                            Sexo.valueOf(rs.getString("sexo")));
                    Main.setParametrosUsuario(p, rs.getLong("id_endereco"));
                    usuarioEncontrado = true;
                }
            }

            if (!usuarioEncontrado) {
                stmt = this.conexao.getConnection().prepareStatement(sqlProfissional);
                stmt.setString(1, login);
                stmt.setString(2, login);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Long id_pessoa = rs.getLong(1);
                    if (id_pessoa != null) {
                        p = new Profissional(id_pessoa,
                                rs.getLong("id_profissional"),
                                rs.getString("cpf"),
                                new Date(rs.getString("data_nascimento")),
                                rs.getString("login"),
                                rs.getString("nome"),
                                rs.getString("numero_sus"),
                                rs.getString("rg"),
                                rs.getString("senha"),
                                Sexo.valueOf(rs.getString("sexo")));
                        Main.setParametrosUsuario(p, rs.getLong("id_endereco"));
                        usuarioEncontrado = true;
                    }
                }
            }

            if (!usuarioEncontrado) {
                stmt = this.conexao.getConnection().prepareStatement(sqlInstuicao);
                stmt.setString(1, login);
                stmt.setString(2, login);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Long id_instituicao = rs.getLong(1);
                    if (id_instituicao != null) {
                        p = new Instituicao(id_instituicao, rs.getString("cnpj"), rs.getString("nome_instituicao"), rs.getString("senha"));
                        usuarioEncontrado = true;
                        Main.setParametrosUsuario(p, rs.getLong("id_endereco"));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (this.conexao != null) {
                this.conexao.close();
            }
        }

        return true;
    }

    public boolean update(Pessoa pessoa) throws SQLException {
        boolean atualizado = false;
        String sql = "update pessoa set nome = ?, login = ?, senha = ?, cpf = ?, rg = ?, numero_sus = ?, data_nascimento = ?, sexo = ? where pessoa.id_pessoa = ?";
        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getLogin());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(3, pessoa.getCpf());
            stmt.setString(4, pessoa.getRegistroGeral());
            stmt.setString(5, pessoa.getNumeroSUS());
            java.sql.Date dataN = new java.sql.Date(pessoa.getDataNascimento().getTime());
            stmt.setDate(6, dataN);
            stmt.setString(7, pessoa.getSexo().toString());
            stmt.setLong(8, pessoa.getId());
            atualizado = (stmt.executeUpdate() == 1);
            this.conexao.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (this.conexao != null) {
                this.conexao.close();
            }
        }
        return atualizado;
    }
}
