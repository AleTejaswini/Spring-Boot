package com.bookpublisher.relationship.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.repository.AuthorRepository;
import com.bookpublisher.relationship.repository.BookRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorrepository;
	@Autowired
	private BookRepository bookrepository;

	
	public List<Author> getauthors(){
		return authorrepository.findAll();
	}
	
	public Author getauthor(int authorid) {
		Author author = authorrepository.findById(authorid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return author;
	}
	
	public Author addauthor(Author author) {
		return authorrepository.save(author);
	}
	
	public Author updateauthor(int authorid , Author newauthor) {
		Author existingauthor = authorrepository.findById(authorid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		existingauthor.setAuthorname(newauthor.getAuthorname());
		authorrepository.save(existingauthor);
		return existingauthor;
	}
	
	public void deleteauthor(int authorid) {
	    try {
	        Author author = authorrepository.findById(authorid).get();  

	        List<Book> books = author.getBooks();
	        for(Book book : books) {
	            book.getAuthors().remove(author);
	        }

	        bookrepository.saveAll(books);
	        authorrepository.deleteById(authorid);

	     
	        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	    }
	    catch (Exception e) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	    }
	}


	public List<Book> getauthorbooks(int authorid){
		Author author = authorrepository.findById(authorid)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return author.getBooks();
	}
}
