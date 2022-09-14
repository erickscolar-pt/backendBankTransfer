package com.banktransfer.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktransfer.model.entity.Transfers;
import com.banktransfer.repository.TransferRepository;

@Service
public class TransferSaveService {

    @Autowired
    private TransferRepository transferRepository;
    

    public Transfers insert(Transfers transfers){
        LocalDate date = LocalDate.now();
        System.out.println("*********** Insert **********");
        System.out.println(transfers.getContaorigem());
        System.out.println(transfers.getContadestino());
        System.out.println(transfers.getDatatransferencia());
        System.out.println(transfers.getDataagendamento());
        System.out.println(transfers.getValor());
        System.out.println("*****************************");
        transfers.setDatatransferencia(date);

        return transferRepository.save(transfers);
    }
}
