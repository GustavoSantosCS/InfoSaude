/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.pin.infosaude.control;

import br.udesc.ceavi.pin.infosaude.control.dao.ConexaoPostgresJDBC;
import br.udesc.ceavi.pin.infosaude.modelo.Campanha;
import br.udesc.ceavi.pin.infosaude.modelo.Vacina;
import br.udesc.ceavi.pin.infosaude.modelo.Instituicao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean validarCampos(String slogan, Date dataInicio, Date dataFim){
        boolean a = true;
        
        if(slogan.equals("")){
            a = false;
            JOptionPane.showMessageDialog(null,"INSIRA UM SLOGAN PARA A CAMPANHA");
        }
        if(dataInicio.getDay() > dataFim.getDay()){
            a = false;
            JOptionPane.showMessageDialog(null,"DADO INVALIDO! DATA INSERIDA INVALIDA \nDIA NÃO CONSISTE!");
        }
        if(dataInicio.getMonth()> dataFim.getMonth()){
            a = false;
            JOptionPane.showMessageDialog(null,"DADO INVALIDO! DATA INSERIDA INVALIDA \nMÊS NÃO CONSISTE!");
        }
        if(dataInicio.getYear() > dataFim.getYear()){
            a = false;
            JOptionPane.showMessageDialog(null,"DADO INVALIDO! DATA INSERIDA INVALIDA \nANO NÃO CONSISTE!");
        }
        
        return a;
    }
    
    public Long inserir(Campanha campanha,Instituicao instituicao,Vacina vacina) throws SQLException,ClassNotFoundException{
        Long id = null;
        String sqlQuery = "insert into campanha(id_instituicao,id_vacina,data_inicio,data_fim) values(?,?,?,?)returning id_campanha";
        
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setInt(1, (int) instituicao.getId());
            stmt.setInt(2, (int) vacina.getId());
            stmt.setDate(3, (Date) campanha.getDataInicio());
            stmt.setDate(4, (Date) campanha.getDataFim());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id_campanha");
            }
            
            this.conexao.commit();
        } catch (SQLException error) {
            this.conexao.rollback();
            throw error;
        }
        
        return id;
    }
}
