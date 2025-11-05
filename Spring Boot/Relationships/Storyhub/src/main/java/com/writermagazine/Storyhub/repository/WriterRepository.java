package com.writermagazine.Storyhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.writermagazine.Storyhub.model.Writer;

public interface WriterRepository extends JpaRepository<Writer,Integer> {

}
