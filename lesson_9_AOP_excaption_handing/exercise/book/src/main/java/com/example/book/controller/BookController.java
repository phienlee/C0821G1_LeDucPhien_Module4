package com.example.book.controller;

import com.example.book.service.impl.BookService;
import com.example.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "id") long bookId) {
		Optional<Book> book = bookService.findById(bookId);
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping
	public Book addBook(@Valid @RequestBody Book book) {
		return bookService.save(book);
	}
}
