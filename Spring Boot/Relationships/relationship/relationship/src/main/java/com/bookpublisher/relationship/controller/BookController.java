package com.bookpublisher.relationship.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpublisher.relationship.model.Author;
import com.bookpublisher.relationship.model.Book;
import com.bookpublisher.relationship.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/getbooks")
	public List<Book> getbooks(){
		return bookservice.getall();
	}
	
	@GetMapping("/getbook/{bookid}")
	public Optional<Book> getbyid(@PathVariable int bookid) {
		return bookservice.getbyid(bookid);
	}
	
	@PostMapping("/addbook")
	public Book addbook(@RequestBody Book book) {
		return bookservice.addbook(book);
	}
	
	@PutMapping("/updatebook/{bookid}")
	public Book updatebook(@PathVariable int bookid,@RequestBody Book newbook){
		return bookservice.updatebook(bookid, newbook);
	}
	
	@DeleteMapping("deletebook/{bookid}")
	public void deletebook(@PathVariable int bookid) {
		 bookservice.delete(bookid);
	}
	
	@GetMapping("getbook/{bookid}/authors")
	public List<Author> getbookauthors(@PathVariable int bookid){
		return bookservice.getbookauthors(bookid);
	}
}

