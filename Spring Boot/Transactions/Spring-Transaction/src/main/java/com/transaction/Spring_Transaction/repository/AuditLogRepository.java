package com.transaction.Spring_Transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.Spring_Transaction.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long>{

}
