package com.goodreads.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goodreads.example.model.Book;
import com.goodreads.example.service.BookService;

@RestController
public class BookController {
	@Autowired
	public BookService bookservice;

	@GetMapping("/getbooks")
	public List<Book> getbooks() {
		return bookservice.getbooks();
	}
	
	@GetMapping("/getbook/{bookid}")
	public Book getbooks(@PathVariable int bookid) {
		return bookservice.getbook(bookid);
	}
	@PostMapping("/addbook")
	public Book addbook(@RequestBody Book book) {
		return bookservice.addbook(book);
	}
	
	@PutMapping("/updatebook/{bookid}")
	public Book updatebook(@PathVariable int bookid,@RequestBody Book book) {
		return bookservice.updatebook(bookid,book);
	}
	
	
	@DeleteMapping("/deletebook/{bookid}")
	public void deletebook(@PathVariable int bookid) {
		 bookservice.deletebook(bookid);
	}
}
