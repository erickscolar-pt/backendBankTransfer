package com.banktransfer.service.exeception;

public class ErrorException extends Exception {
    
    @Override
    public String getMessage(){
        return "Não existe taxa para este valor";
      }

}
