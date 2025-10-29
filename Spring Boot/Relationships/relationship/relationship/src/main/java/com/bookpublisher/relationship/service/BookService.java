package com.bookpublisher.relationship.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.model.Publisher;
import com.bookpublisher.relationship.repository.BookRepository;
import com.bookpublisher.relationship.repository.PublisherRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private PublisherRepository publisherrepository;

	public List<Book> getall() {
		return bookrepository.findAll();
	}

	public Optional<Book> getbyid(int bookid) {
		try {
			Optional<Book> book = bookrepository.findById(bookid);
			return book;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public Book addbook(Book book) {
		Publisher publisher = book.getPublisher();
		int publisherid = publisher.getPublisherid();
		try {
			Publisher completepublisher = publisherrepository.findById(publisherid).get();
			book.setPublisher(completepublisher);
			bookrepository.save(book);
			return book;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong publisher");

		}
	}

	public Book updatebook(int bookid, Book newbook) {
		
		try {
			Book existingbook = bookrepository.findById(bookid).get();
			Publisher publisher = newbook.getPublisher();
			int publisherid = publisher.getPublisherid();
			Publisher completepublisher = publisherrepository.findById(publisherid).get();
			existingbook.setBookname(newbook.getBookname());
			existingbook.setPublisher(completepublisher);
			bookrepository.save(existingbook);
			return existingbook;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public void delete(int bookid) {
		bookrepository.deleteById(bookid);
	}

}
