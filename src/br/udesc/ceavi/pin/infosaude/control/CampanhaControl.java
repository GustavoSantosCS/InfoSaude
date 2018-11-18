package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Campanha;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import br.udesc.ceavi.pin.infosaude.principal.Main;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class CampanhaControl {

    private final ConexaoPostgresJDBC conexao;

    public CampanhaControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public boolean validarCampos(String slogan, Date dataInicio, Date dataFim) {
        boolean a = true;

        if (slogan.equals("")) {
            a = false;
            JOptionPane.showMessageDialog(null, "INSIRA UM SLOGAN PARA A CAMPANHA");
        }
        if (dataInicio.getDay() > dataFim.getDay()) {
            a = false;
            JOptionPane.showMessageDialog(null, "DADO INVALIDO! DATA INSERIDA INVALIDA \nDIA NÃO CONSISTE!");
        }
        if (dataInicio.getMonth() > dataFim.getMonth()) {
            a = false;
            JOptionPane.showMessageDialog(null, "DADO INVALIDO! DATA INSERIDA INVALIDA \nMÊS NÃO CONSISTE!");
        }
        if (dataInicio.getYear() > dataFim.getYear()) {
            a = false;
            JOptionPane.showMessageDialog(null, "DADO INVALIDO! DATA INSERIDA INVALIDA \nANO NÃO CONSISTE!");
        }

        return a;
    }

    public Long inserir(Campanha campanha, Instituicao instituicao, Vacina vacina) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "insert into campanha(id_instituicao,id_vacina,data_inicio,data_fim) values(?,?,?,?)returning id_campanha";

        PreparedStatement stmt = null;
        try {
            stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setInt(1, (int) instituicao.getId());
            stmt.setInt(2, (int) vacina.getId());
            stmt.setDate(3, (Date) campanha.getDataInicio());
            stmt.setDate(4, (Date) campanha.getDataFim());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getLong("id_campanha");
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

    //Obtem as campanhas participada pelo usuario
    public List<Campanha> getCampanhaUsuario() throws SQLException {
        List<Campanha> listaDeCampanha = new ArrayList();
        String sqlQuery1 = "select c.id_campanha,c.slogam,c.id_vacina,c.data_inicio,c.data_fin"
                + "from carterinha natural inner join campanha"
                + "where c.id_usuario = ?";
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery1);
        stmt.setLong(1, Main.privilegio.getId());
        stmt.execute();
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            Campanha campanha = new Campanha();
            campanha.setId(resultSet.getLong("id_campanha"));
            campanha.setSlogan(resultSet.getString("slogam"));
            campanha.setVacina(new Vacina(resultSet.getLong("id_vacina")));
            campanha.setDataFim(new Date(resultSet.getShort(resultSet.getString("data_fim"))));
            campanha.setDataInicio(new Date(resultSet.getShort(resultSet.getString("data_inicio"))));
            listaDeCampanha.add(campanha);
        }
        stmt.close();
        this.conexao.close();
        return listaDeCampanha;
    }

    //Obtem todas as campanha
    public List<Campanha> getCampanhas() throws SQLException {
        List<Campanha> listaDeCampanha = new ArrayList();
        String sqlQuery = "select * from campanha natural inner join vacina";
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
        stmt.execute();
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            Campanha campanha = new Campanha();
            campanha.setId(resultSet.getLong("id_campanha"));
            campanha.setSlogan(resultSet.getString("slogam"));
            Vacina vacina = new Vacina(resultSet.getLong("id_vacina"), 
                    resultSet.getInt("num_doses") , resultSet.getString("nome_vacina"),resultSet.getString("observacao"));
            campanha.setVacina(vacina);
            campanha.setDataFim(new Date(resultSet.getShort(resultSet.getString("data_fim"))));
            campanha.setDataInicio(new Date(resultSet.getShort(resultSet.getString("data_inicio"))));
            listaDeCampanha.add(campanha);
        }
        
        stmt.close();
        this.conexao.close();
        return listaDeCampanha;
    }

}
