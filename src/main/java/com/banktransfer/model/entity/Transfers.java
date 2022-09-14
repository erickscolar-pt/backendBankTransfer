package com.banktransfer.model.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "transferencias")
public class Transfers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "conta_origem", nullable = false)
    private Number contaorigem;
    
    @Column(name = "conta_destino", nullable = false)
    private Number contadestino;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "data_transferencia", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datatransferencia;

    @Column(name = "data_agendamento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataagendamento;
}
