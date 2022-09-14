package com.banktransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banktransfer.model.entity.Transfers;
import com.banktransfer.repository.TransferRepository;

@Service
public class TransferSaveService {

    @Autowired
    private TransferRepository transferRepository;  

    public Transfers insert(Transfers transfers){
        System.out.println("*********** Insert **********");
        System.out.println(transfers.getContaorigem());
        System.out.println(transfers.getContadestino());
        System.out.println(transfers.getDatatransferencia());
        System.out.println(transfers.getDataagendamento());
        System.out.println(transfers.getValor());
        System.out.println(transfers.getTaxa());
        System.out.println("*****************************");

        
        return transferRepository.save(transfers);
    }
}
