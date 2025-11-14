package com.goodreads.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.goodreads.example.model.BookRowMapper;
import com.goodreads.example.model.Book;

@Service
public class BookService {
	@Autowired
	private JdbcTemplate db;

	public ArrayList<Book> getbooks() {
		List<Book> booklist = db.query("select * from book", new BookRowMapper());
		ArrayList<Book> books = new ArrayList<>(booklist);
		return books;
	}

	public Book getbook(int bookid) {
		try {
			Book book = db.queryForObject("select * from book where id= ?", new BookRowMapper(), bookid);
			return book;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Book addbook(Book book) {
		db.update("insert into book (name) values ?",book.getName());
		Book savedbook= db.queryForObject("select * from book where name=?" , new BookRowMapper(),book.getName());
		return savedbook;
	}
	
	public Book updatebook(int bookid,Book book) {
		if(book.getName()!=null) {
			db.update("update book set name =? where id=?", book.getName(),bookid);
		}
		return getbook(bookid);
		
	}
	
	
	public void deletebook(int bookid) {
	
	int rows = db.update("delete from book where id =?", bookid);
	if(rows==0) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found");
	}
	}
	

}
