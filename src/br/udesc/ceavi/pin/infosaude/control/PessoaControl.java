
package br.udesc.ceavi.pin.infosaude.control;


import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import br.udesc.ceavi.pin.infosaude.modelo.Pessoa;
import br.udesc.ceavi.pin.infosaude.modelo.Endereco;
import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoJDBC;
import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class PessoaControl {

    private final ConexaoPostgresJDBC conexao;

    public PessoaControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public boolean validaCampoLogin(String login) throws SQLException, DadosVaziosExcepitions {
        boolean a = true;
        if (login.equals("")) {
            a = false;
            throw new DadosVaziosExcepitions("LOGIN INVALIDADO!");
        } else {
            String sql = "Select from pessoa(login) where login = '?' returning login;";
            try {
                PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
                stmt.setString(1, login);

                ResultSet rs = stmt.executeQuery();
                String rsLogin = rs.getString("login");
                if (login.equals(rsLogin)) {
                    a = false;
                    throw new DadosVaziosExcepitions("LOGIN INVALIDO! \nESTE LOGIN JA EXISTE!");
                }
                this.conexao.commit();
            } catch (SQLException error) {
                this.conexao.rollback();
                throw error;
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
        validaCampoLogin(login);
        a = validaCampoLogin(login);
        return a;
    }

    
    public Long inserir(Pessoa pessoa,Endereco endereco) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into pessoa(id_endereco,nome,login,senha,cpf,rg,numero_sus,data_nascimento,sexo) values(?,?,?,?,?,?,?,?)returning id_pessoa";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, endereco.getId());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getLogin());
            stmt.setString(4, pessoa.getSenha());
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, pessoa.getRegistroGeral());
            stmt.setString(7, pessoa.getNumeroSUS());
            stmt.setDate(8, (Date) pessoa.getDataNascimento());
            stmt.setString(9, pessoa.getSexo().toString());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id_pessoa");
            }
            
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }
        
        return id;
    }
    
}
