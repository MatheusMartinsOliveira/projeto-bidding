/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.bidding.model;

import java.sql.Date;

/**
 *
 * @author farma
 */
public class LanceDTO {
    private Long id;
    private Double valor;
    private Date dataLance;
    
    public LanceDTO() {
    }

    public LanceDTO(Long id, Double valor, Date dataLance, Long idEdital, Long idUsuario) {
        this.id = id;
        this.valor = valor;
        this.dataLance = dataLance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataLance() {
        return dataLance;
    }

    public void setDataLance(Date dataLance) {
        this.dataLance = dataLance;
    }

    
}
