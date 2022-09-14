package com.banktransfer.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banktransfer.model.entity.Transfers;
import com.banktransfer.repository.TransferRepository;
import com.banktransfer.service.exeception.ErrorException;

@Service
public class TransferSaveService {

    @Autowired
    private TransferRepository transferRepository;

    public Double calculaTaxa(Double valor, Long diff){

        Double taxa = 0.0;

        if(valor <= 1000.00){
            if(diff <= 10){
                System.out.println("Taxação A => " + 3/100*valor + 3);
                taxa = 3/100*valor + 3;
            }
        } else if(valor <= 2000.00 && valor >= 1000.01){
            if(diff <= 20 && diff > 10){
                System.out.println("Taxação B => " + 12);
                taxa = 12.0;
            }
        } else if(valor > 2000.00){
            //System.out.println("Taxação D conforme o dia");
            if(diff>=10 && diff < 20){
                //System.out.println("Taxação => " + 8.2/100*valor);
                taxa = 8.2/100*valor;
            } else if(diff>=20 && diff < 30){
                //System.out.println("Taxação => " + 6.9/100*valor);
                taxa = 6.9/100*valor;
            }else if(diff>=30 && diff < 40){
                //System.out.println("Taxação => " + 4.7/100*valor);
                taxa = 4.7/100*valor;
            }else if(diff>=40){
                //System.out.println("Taxação => " + 1.7/100*valor);
                taxa = 1.7/100*valor;
            } else {
                //System.out.println("Não existe taxa");
                taxa = 0.0;
            }
        }
        return taxa;
    }
    


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

        LocalDate dBefore = LocalDate.parse(date.toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate dAfter = LocalDate.parse(transfers.getDataagendamento().toString(), DateTimeFormatter.ISO_LOCAL_DATE);

        long diff = dBefore.until(dAfter,ChronoUnit.DAYS);
        //System.out.println("Diff : "+diff +" dias");

        Double valor = transfers.getValor();

        Double taxa = calculaTaxa(valor, diff);
        if(taxa == 0.0){
            try {
                throw new ErrorException();
            } catch (ErrorException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        transfers.setTaxa(taxa);
        //System.out.println(taxa);

        return transferRepository.save(transfers);
    }
}
