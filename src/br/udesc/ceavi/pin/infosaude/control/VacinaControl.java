package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.control.excecpton.DadosVaziosExcepitions;
import br.udesc.ceavi.pin.infosaude.modelo.Campanha;
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
import java.util.Calendar;
import java.util.Date;
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
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (conexao != null) {
                this.conexao.close();
            }
        }
        return listaPublicoAlvo;
    }

    //Inserir vacina
    public Long inserir(int doses, String nome, String obs) throws SQLException {
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
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (conexao != null) {
                this.conexao.close();
            }
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
        String sqlQuery1 = "select v.id_vacina, v.nome_vacina,c.dose_aplicada,c.observacoes,c.id_profissional, p.nome_pessoa as profissional, p.id_pessoa"
                + "from vacina as v natural inner join carterinha as c natura inner join pessoa as p"
                + "where c.id_usuario = ?";
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery1);
        stmt.setLong(1, Main.usuario.getId());
        stmt.execute();
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            Vacina vacina = new Vacina();
            vacina.setId(resultSet.getInt("id_vacina"));
            vacina.setVacina(resultSet.getString("nome_vacina"));
            vacina.setDose(resultSet.getInt("dose_aplivada"));
            vacina.setObservacao(resultSet.getString("observacoes"));
            vacina.setProfissional(new Profissional(resultSet.getLong("id_pessoa"), resultSet.getLong("id_profissional"), resultSet.getString("profissional")));
            listaDeVacina.add(vacina);
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
            }
        }
        if (conexao != null) {
            this.conexao.close();
        }
        return listaDeVacina;
    }

    //Obter Numero de pessoa condizentes com o publico alvo informado
    public int getNumeroPessoaCondizentesComOPublicoAlvo(PublicoAlvo publico_alvo) {

        return -1;
    }

    public int getNumPessoaQueAplicaramVacinaPerantePublicoAlvo(PublicoAlvo publico_alvo, long id_vacina) {
        return -1;
    }

    public Vacina getVacinaPeloNome(String nome_vacina) {
        System.out.println("Nome passado :" + nome_vacina);
        String sqlQuery = "select v.id_vacina, v.num_doses from vacina as v where v.nome_vacina ~* ?";
        Vacina vacina = null;
        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, nome_vacina);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                vacina = new Vacina();
                vacina.setId(rs.getLong(1));
                vacina.setDose(rs.getInt(2));
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
        return vacina;
    }

    public boolean aplicarVacina(Long id_vacina, Long id_usuario, Long id_campanha, Long id_profissional, int dose, String observacoes) throws SQLException {
        String sqlQueryComCampanhaEOBS = "insert into carterinha(id_usuario,id_vacina,id_campanha,id_profissional,data_aplicacao,observacoes,dose_aplicada)"
                + "values (?,?,?,?,?,?,?);";
        String sqlQueryComOBS = "insert into carterinha(id_usuario,id_vacina,id_profissional,data_aplicacao,observacoes,dose_aplicada)"
                + "values (?,?,?,?,?,?);";
        String sqlQuery1ComCampanha = "insert into carterinha(id_usuario,id_vacina,id_campanha,id_profissional,data_aplicacao,dose_aplicada)"
                + "values (?,?,?,?,?,?);";
        String sqlQuerySIMPLE = "insert into carterinha(id_usuario,id_vacina,id_profissional,data_aplicacao,dose_aplicada)"
                + "values (?,?,?,?,?);";
        PreparedStatement stmt = null;
        int q = -1;
        try {
            if (id_campanha == -1 && observacoes.equals("")) {
                stmt = this.conexao.getConnection().prepareStatement(sqlQuerySIMPLE);
                stmt.setLong(1, id_usuario);
                stmt.setLong(2, id_vacina);
                stmt.setLong(3, id_profissional);
                stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                stmt.setInt(5, dose);
            } else if (id_campanha != -1 && observacoes.equals("")) {
                stmt = this.conexao.getConnection().prepareStatement(sqlQuery1ComCampanha);
                stmt.setLong(1, id_usuario);
                stmt.setLong(2, id_vacina);
                stmt.setLong(3, id_campanha);
                stmt.setLong(4, id_profissional);
                stmt.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                stmt.setInt(6, dose);
            } else if (id_campanha == -1 && !observacoes.equals("")) {
                stmt = this.conexao.getConnection().prepareStatement(sqlQueryComOBS);
                stmt.setLong(1, id_usuario);
                stmt.setLong(2, id_vacina);
                stmt.setLong(3, id_profissional);
                stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                stmt.setString(5, observacoes);
                stmt.setInt(6, dose);
            } else if (id_campanha != -1 && !observacoes.equals("")) {
                stmt = this.conexao.getConnection().prepareStatement(sqlQueryComCampanhaEOBS);
                stmt.setLong(1, id_usuario);
                stmt.setLong(2, id_vacina);
                stmt.setLong(4, id_profissional);
                stmt.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
                stmt.setString(6, observacoes);
                stmt.setInt(7, dose);
            }
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
        } catch (SQLException ex) {
            this.conexao.rollback();
            throw ex;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (conexao != null) {
                this.conexao.close();
            }
        }

        return true;
    }

    public List<Campanha> getCampanhaDoUsuario(Long id_usuario) throws SQLException {
        List<Campanha> lista = new ArrayList<>();
        String sql = "select p.id_pessoa,c.id_profissional,p.nome_pessoa, c.data_aplicacao,"
                + "c.dose_aplicada, v.nome_vacina,camp.slogan,camp.data_inicio,camp.data_fim"
                + "from carterinha as c natural inner join campanha as camp "
                + "natural inner join vacina as v"
                + "inner join pessoa as p on (p.id_pessoa = c.id_profissional) where c.id_usuario = ?";
        PreparedStatement stmt = null;
        Vacina vacinaDaCampanha;
        Campanha campanha;
        Profissional prof;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setLong(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                prof = new Profissional(rs.getLong("id_pessoa"), rs.getLong("id_profissional"), rs.getString("nome_profissional"));
                vacinaDaCampanha = new Vacina(new Date(rs.getString("data_aplicacao")), rs.getInt("dose_aplicada"), rs.getString("nome_vacina"), prof);
                campanha = new Campanha(rs.getString("slogan"), vacinaDaCampanha, new Date(rs.getString("data_inicio")), new Date(rs.getString("data_fim")));
                lista.add(campanha);
            }
        } catch (SQLException ex) {
            this.conexao.rollback();
            throw ex;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (conexao != null) {
                this.conexao.close();
            }
        }

        return lista;
    }

    public List<Vacina> getVacinaDoUsuario(Long id_usuario) throws SQLException {
        List<Vacina> lista = new ArrayList<>();
        String sql = "select p.id_pessoa,c.id_profissional,p.nome_pessoa, c.data_aplicacao,"
                + "c.dose_aplicada, v.nome_vacina"
                + "from carterinha as c"
                + "natural inner join vacina as v"
                + "inner join pessoa as p on (p.id_pessoa = c.id_profissional) where c.id_usuario = ?";
        PreparedStatement stmt = null;
        Vacina vacinaDaCampanha;
        Profissional prof;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sql);
            stmt.setLong(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                prof = new Profissional(rs.getLong("id_pessoa"), rs.getLong("id_profissional"), rs.getString("nome_profissional"));
                vacinaDaCampanha = new Vacina(new Date(rs.getString("data_aplicacao")), rs.getInt("dose_aplicada"), rs.getString("nome_vacina"), prof);
                lista.add(vacinaDaCampanha);
            }
        } catch (SQLException ex) {
            this.conexao.rollback();
            throw ex;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
            if (conexao != null) {
                this.conexao.close();
            }
        }
        return lista;
    }
}
