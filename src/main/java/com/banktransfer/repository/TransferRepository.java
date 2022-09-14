package com.banktransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banktransfer.model.entity.Transfers;

@Repository
public interface TransferRepository extends JpaRepository<Transfers, Long>{
    
}
