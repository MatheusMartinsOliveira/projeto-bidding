/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.bidding.service;

import com.bidding.system.bidding.model.EditalDTO;
import com.bidding.system.bidding.model.LanceDTO;
import com.bidding.system.bidding.model.UserDTO;
import com.bidding.system.bidding.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author farma
 */
@Service
public class LanceService {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private LanceRepository lanceRepository;
    
    public void criarLance(Long id, LanceDTO lance, String token) {
        if(tokenService.validarToken(token)){
            UserDTO usuarioLogado = tokenService.extrairClaims(token);
            if(!usuarioLogado.getRole().equals("FORNECEDOR")) {
                throw new ResponseStatusException(HttpStatusCode.valueOf(403), "Você precisa ser Fornecedor para criar um lance!");
            }
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(401), "Token inválido!");
        }
    }
}
