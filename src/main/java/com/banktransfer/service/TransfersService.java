package com.banktransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banktransfer.model.entity.Transfers;

@Service
public class TransfersService {

    @Autowired
    private TransferSaveService transferSaveService;

    public Transfers transfers(Transfers transfers){

        System.out.println("***** Classe para tratar as regras *****");  


        transferSaveService.insert(transfers);
        return transfers;
    }

    
    
}
