package com.schedulerconfig.SchedulerDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schedulerconfig.SchedulerDB.entity.SchedulerEntity;
@Repository
public interface SchedulerRepository extends JpaRepository<SchedulerEntity, Integer> {

}
