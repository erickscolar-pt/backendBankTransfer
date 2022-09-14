package com.banktransfer.model.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TransfersDTO {

    @NotEmpty(message = "{campo.contaorigem.obrigatorio}")
    private Number contaorigem;
    
    @NotEmpty(message = "{campo.contadestino.obrigatorio}")
    private Number contadestino;
    
    @NotEmpty(message = "{campo.data.obrigatorio}")
    private LocalDate datatransferencia;
    
    @NotEmpty(message = "{campo.data.obrigatorio}")
    private Date dataagendamento;

}
