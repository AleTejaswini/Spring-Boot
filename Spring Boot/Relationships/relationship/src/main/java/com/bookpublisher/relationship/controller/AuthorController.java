package com.bookpublisher.relationship.controller;

import java.util.List;

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
import com.bookpublisher.relationship.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorservice;

	@GetMapping("/getauthors")
	public List<Author> getauthors() {
		return authorservice.getauthors();
	}

	@GetMapping("/getauthor/{authorid}")
	public Author getauthor(@PathVariable int authorid) {
		return authorservice.getauthor(authorid);
	}

	@PostMapping("/addauthor")
	public Author addauthor(@RequestBody Author author) {
		return authorservice.addauthor(author);
	}

	@DeleteMapping("/deleteauthor/{authorid}")
	public void deleteauthor(@PathVariable int authorid) {
		authorservice.deleteauthor(authorid);
	}

	@GetMapping("/getauthor/{authorid}/books")
	public List<Book> getauthorbooks(@PathVariable int authorid) {
		return authorservice.getauthorbooks(authorid);
	}

	@PutMapping("updateauthor/{authorid}")
	public Author updateauthor(@PathVariable int authorid, @RequestBody Author newauthor) {
		return authorservice.updateauthor(authorid, newauthor);
	}
}
