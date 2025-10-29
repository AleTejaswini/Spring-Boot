package com.bookpublisher.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpublisher.relationship.model.Publisher;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer>{

}
