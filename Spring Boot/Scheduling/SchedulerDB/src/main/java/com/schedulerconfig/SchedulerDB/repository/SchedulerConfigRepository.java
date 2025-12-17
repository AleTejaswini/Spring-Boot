package com.schedulerconfig.SchedulerDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schedulerconfig.SchedulerDB.entity.SchedulerConfigEntity;
@Repository
public interface SchedulerConfigRepository extends JpaRepository<SchedulerConfigEntity, Integer> {

}
