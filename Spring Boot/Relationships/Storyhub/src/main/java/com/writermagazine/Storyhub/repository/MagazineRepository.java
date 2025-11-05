package com.writermagazine.Storyhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.writermagazine.Storyhub.model.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine,Integer>{

}
