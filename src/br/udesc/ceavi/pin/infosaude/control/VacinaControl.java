/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.PublicoAlvo;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

//    public List listaVacina(){
////        List<Vacina> listaVacina = new ArrayList<>();
//        
//        return;
//    }
    
    public Long inserir(Vacina vacina,PublicoAlvo publicoAlvo) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into vacina(id_publico_alvo,dose,vacina,observacao) values(?,?,?,?)returning id_vacina";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setInt(1, (int) publicoAlvo.getId());
            stmt.setFloat(2, vacina.getDose());
            stmt.setString(3, vacina.getVacina());
            stmt.setString(4, vacina.getObservacao());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id_vacina");
            }
            
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }
        
        return id;
    }
    
    /*
    *Aplicação da vacina, update da tabela vacina inserindo id_profissional e data_aplicacao
    */
    public Long aplicarVacina(Vacina vacina)throws SQLException,ClassNotFoundException{
        Long id = null;
        
        
        return id;
    }
}
