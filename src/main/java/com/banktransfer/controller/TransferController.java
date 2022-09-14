package com.banktransfer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banktransfer.model.entity.Transfers;
import com.banktransfer.repository.TransferRepository;
import com.banktransfer.service.TransfersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/transfer")
@AllArgsConstructor
public class TransferController {

    private final TransferRepository transferRepository;

    @Autowired
    private TransfersService transfersService;

    @GetMapping
    public @ResponseBody List<Transfers> list(){
        return transferRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> scheduleTransfer(@RequestBody Transfers transfers){
      return ResponseEntity.ok(transfersService.transfers(transfers));

    }
    
}
