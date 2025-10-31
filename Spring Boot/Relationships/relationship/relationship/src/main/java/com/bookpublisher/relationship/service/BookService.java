package com.bookpublisher.relationship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.model.Publisher;
import com.bookpublisher.relationship.repository.AuthorRepository;
import com.bookpublisher.relationship.repository.BookRepository;
import com.bookpublisher.relationship.repository.PublisherRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private PublisherRepository publisherrepository;
	@Autowired
	private AuthorRepository authorrepository;


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
		List<Integer> authorIds = new ArrayList<>();
		for (Author author : book.getAuthors()) {
			authorIds.add(author.getAuthorid());
		}
		Publisher publisher = book.getPublisher();
		int publisherid = publisher.getPublisherid();
		try {
			List<Author> completeauthor = authorrepository.findAllById(authorIds);
			if(authorIds.size()!= completeauthor.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"one or more authorids are invalid");
			}
			book.setAuthors(completeauthor);
			
			Publisher completepublisher = publisherrepository.findById(publisherid).get();
			book.setPublisher(completepublisher);
			
			bookrepository.save(book);
			return book;

		} catch (NoSuchElementException e) {
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
	
	public List<Author> getbookauthors(int bookid){
		Book book = bookrepository.findById(bookid)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return book.getAuthors();
	}

}
