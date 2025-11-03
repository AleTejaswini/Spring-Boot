package com.bookpublisher.relationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.model.Publisher;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByPublisher(Publisher publisher);
}