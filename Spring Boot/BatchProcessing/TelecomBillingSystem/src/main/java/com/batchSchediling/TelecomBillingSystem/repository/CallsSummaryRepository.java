package com.batchSchediling.TelecomBillingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batchSchediling.TelecomBillingSystem.entity.CallsSummary;

public interface CallsSummaryRepository extends JpaRepository<CallsSummary, Integer> {

}
