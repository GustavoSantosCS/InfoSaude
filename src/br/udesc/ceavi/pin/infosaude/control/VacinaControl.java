package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.modelo.Profissional;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import br.udesc.ceavi.pin.infosaude.modelo.Sexo;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import br.udesc.ceavi.pin.infosaude.principal.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class VacinaControl {

    private final ConexaoPostgresJDBC conexao;

    public VacinaControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    //Obter vacina cadastrar em banco
    public List<Vacina> getVacinas() throws SQLException {
        List<Vacina> listaVacina = new ArrayList<>();
        String sqlQuery = "select * from vacina as v";
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
        stmt.execute();
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            Vacina vacina = new Vacina(resultSet.getLong("id_vacina"),
                    resultSet.getInt("num_doses"), resultSet.getString("nome_vacina"), resultSet.getString("observacao"));
            listaVacina.add(vacina);
        }
        return listaVacina;
    }

    //Obter publico alvo de vacina
    public List<PublicoAlvo> obterPublicoAlvo(Long id_vacina) throws SQLException {
        List<PublicoAlvo> listaPublicoAlvo = new ArrayList<>();
        String sqlQuery = "select pa.max_idade,pa.min_idade,pa.sexo from publico_alvo as pa natural inner join vacina where pa.id_vacina = ?";
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
        stmt.setLong(1, id_vacina);

        stmt.execute();
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            PublicoAlvo publicoAlvo = new PublicoAlvo();

            publicoAlvo.setMinIdade(resultSet.getInt("max_idade"));
            publicoAlvo.setMaxIdade(resultSet.getInt("min_idade"));
            publicoAlvo.setSexo(Sexo.valueOf(resultSet.getString("sexo")));

            listaPublicoAlvo.add(publicoAlvo);
        }
        stmt.close();
        this.conexao.close();
        return listaPublicoAlvo;
    }

    //Inserir vacina
    public Long inserir(int doses, String nome, String obs) throws SQLException, ClassNotFoundException {
        Long id_vacina = null;
        String sqlQueryComObs = "insert into vacina(num_doses,nome_vacina,observacao) values(?,?,?)";
        String sqlQuerySemObs = "insert into vacina(num_doses,nome_vacina) values(?,?)";

        PreparedStatement stmt = null;
        try {
            if (!obs.equals("")) {
                stmt = this.conexao.getConnection().prepareStatement(sqlQueryComObs, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, doses);
                stmt.setString(2, nome);
                stmt.setString(3, obs);
            } else {
                stmt = this.conexao.getConnection().prepareStatement(sqlQuerySemObs, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, doses);
                stmt.setString(2, nome);
            }
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id_vacina = rs.getLong(1);
            }
            System.out.println("KEY: " + id_vacina);
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        } finally {
            stmt.close();
            this.conexao.close();
        }
        return id_vacina;
    }

    //Validar dados de vacina
    public boolean validarVacina(int numeroDoses, String nomeVacina) throws DadosVaziosExcepitions {
        if (numeroDoses < 1) {
            throw new DadosVaziosExcepitions("Numero de Dose Incompativel");
        }
        if (nomeVacina.equals("")) {
            throw new DadosVaziosExcepitions("Numero de Dose Incompativel");
        }
        return true;
    }

    //Obtem as Vacinas aplicadas no usuario
    public List<Vacina> getVacinaUsuario() throws SQLException {
        List<Vacina> listaDeVacina = new ArrayList();
        String sqlQuery1 = "select v.id_vacina, v.nome_vacina,c.dose_aplicada,c.observacoes,c.id_profissional, p.nome_pessoa as profissional"
                + "from vacina as v natural inner join carterinha as c natura inner join pessoa as p"
                + "where c.id_usuario = ?";
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery1);
        stmt.setLong(1, Main.privilegio.getId());
        stmt.execute();
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            Vacina vacina = new Vacina();
            vacina.setId(resultSet.getInt("id_vacina"));
            vacina.setVacina(resultSet.getString("nome_vacina"));
            vacina.setDose(resultSet.getInt("dose_aplivada"));
            vacina.setObservacao(resultSet.getString("observacoes"));
            vacina.setProfissional(new Profissional(resultSet.getLong("id_profissional"), resultSet.getString("profissional")));
            listaDeVacina.add(vacina);
        }
        stmt.close();
        this.conexao.close();
        return listaDeVacina;
    }

    public Long aplicarVacina(Vacina vacina) throws SQLException, ClassNotFoundException {
        Long id = null;
        return id;
    }

    //Obter Numero de pessoa condizentes com o publico alvo informado
    public int getNumeroPessoaCondizentesComOPublicoAlvo(PublicoAlvo publico_alvo) {

        return -1;
    }

    public int getNumPessoaQueAplicaramVacinaPerantePublicoAlvo(PublicoAlvo publico_alvo, long id_vacina) {

        return -1;
    }
}
