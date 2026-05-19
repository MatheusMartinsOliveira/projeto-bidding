/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.bidding.repository;

import com.bidding.system.bidding.model.EditalDTO;
import com.bidding.system.bidding.model.LanceDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author farma
 */
@Repository
public class LanceRepository {
    
    public int cadastrarLance(LanceDTO lance) {
        try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = null;
        
        stmt = conn.prepareStatement("INSERT INTO lances (valor, data_lance) VALUES (?, ?)");
        stmt.setDouble(1, lance.getValor());
        stmt.setDate(2, lance.getDataLance());
        
        return stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } return 0;
    }
    
    public List<EditalDTO> lerTodos() {
        List<EditalDTO> listar = new ArrayList();
            try{
            
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            stmt = conn.prepareStatement("select * from editais");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                EditalDTO edital = new EditalDTO();
                edital.setId(rs.getLong("id"));
                edital.setTitulo(rs.getString("titulo"));
                edital.setDescricao(rs.getString("descricao"));
                edital.setDataFechamento(rs.getDate("data_fechamento"));
                edital.setStatus(rs.getString("status"));
                listar.add(edital);
            }
           
            
        } catch(SQLException e) {
            e.printStackTrace();
        }return listar;
    } 
}
