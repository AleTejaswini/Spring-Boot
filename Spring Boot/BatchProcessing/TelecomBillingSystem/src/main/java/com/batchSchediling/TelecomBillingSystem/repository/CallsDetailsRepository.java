package com.batchSchediling.TelecomBillingSystem.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.batchSchediling.TelecomBillingSystem.entity.CallsDetails;

public interface CallsDetailsRepository 
extends JpaRepository<CallsDetails, Integer> {

Optional<CallsDetails> findByMobilenumAndCallDate(
    String mobilenum,
    LocalDate callDate
);
}
