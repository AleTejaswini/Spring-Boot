package com.bookpublisher.relationship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.model.Publisher;
import com.bookpublisher.relationship.repository.AuthorRepository;
import com.bookpublisher.relationship.repository.BookRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorrepository;
	@Autowired
	private BookRepository bookrepository;

	public List<Author> getauthors() {
		return authorrepository.findAll();
	}

	public Author getauthor(int authorid) {
		Author author = authorrepository.findById(authorid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return author;
	}

	public Author addauthor(Author author) {
		List<Integer> bookids = new ArrayList<>();
		for (Book book : author.getBooks()) {
			bookids.add(book.getBookid());
		}
		try {
			List<Book> completebook = bookrepository.findAllById(bookids);
			if (bookids.size() != completebook.size()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "one or more bookids are invalid");
			}
			author.setBooks(completebook);
			for (Book b : completebook) {
				b.getAuthors().add(author);
			}
			return authorrepository.save(author);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong bookids");
		}
	}

	public Author updateauthor(int authorid, Author updatedauthor) {
		Author existingauthor = authorrepository.findById(authorid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		List<Integer> bookids = new ArrayList<>();
		for (Book book : updatedauthor.getBooks()) {
			bookids.add(book.getBookid());
		}
		List<Book> completebook = bookrepository.findAllById(bookids);
		if (bookids.size() != completebook.size()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "one or more bookids are invalid");
		}
		for (Book b : completebook) {
			b.getAuthors().add(existingauthor);
		}
		existingauthor.setBooks(completebook);
		existingauthor.setAuthorname(updatedauthor.getAuthorname());
		authorrepository.save(existingauthor);
		return existingauthor;
	}

	public void deleteauthor(int authorid) {
		try {
			Author author = authorrepository.findById(authorid).get();

			List<Book> books = author.getBooks();
			for (Book book : books) {
				book.getAuthors().remove(author);
			}
			bookrepository.saveAll(books);
			authorrepository.deleteById(authorid);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
	}

	public List<Book> getauthorbooks(int authorid) {
		Author author = authorrepository.findById(authorid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return author.getBooks();
	}
}
