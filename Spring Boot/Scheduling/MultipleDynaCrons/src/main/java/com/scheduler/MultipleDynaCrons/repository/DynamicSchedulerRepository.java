package com.scheduler.MultipleDynaCrons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.MultipleDynaCrons.entity.Scheduler;


@Repository
public interface DynamicSchedulerRepository extends JpaRepository<Scheduler,Integer>{

}
