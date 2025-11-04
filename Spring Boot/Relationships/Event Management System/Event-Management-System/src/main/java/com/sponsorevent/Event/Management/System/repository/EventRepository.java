package com.sponsorevent.Event.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sponsorevent.Event.Management.System.model.Event;

public interface EventRepository extends JpaRepository<Event,Integer>{

}
