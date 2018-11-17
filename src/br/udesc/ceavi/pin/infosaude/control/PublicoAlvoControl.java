package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class PublicoAlvoControl {
    private final ConexaoPostgresJDBC conexao;

    public PublicoAlvoControl() throws ClassNotFoundException, SQLException {
        this.conexao = new ConexaoPostgresJDBC();
    }

    public Long inserir(PublicoAlvo publicoAlvo,long id_vacina) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into publicoAlvo(id_vacina,min_idade,max_idade,sexo) values(?,?,?,?)returning id_publicoAlvo";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, id_vacina);
            stmt.setInt(2, publicoAlvo.getMinIdade());
            stmt.setInt(3, publicoAlvo.getMaxIdade());
            stmt.setString(4, publicoAlvo.getSexo().toString());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id_publicoAlvo");
            }
            this.conexao.commit();
            this.conexao.close();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }
        
        return id;
    }
}
