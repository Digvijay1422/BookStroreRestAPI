package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;

@RestController
public class BookController {
	@Autowired
	Bs bs;
	@GetMapping("/get")
	public Book hello()
	{
		Book book = this.bs.getBookById1(1);
		return book;
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list = this.bs.getAllBooks();
		if(list.size()<=0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = this.bs.getBookById(id);
		

		if(book==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{

		book = this.bs.addBook(book);
		return book;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bs.deleteBook(bookId);
	}
	
	//Update the book
	@PutMapping("/book/{bookId}")
	public void updateBook(@RequestBody Book book, @PathVariable("bookId") int id )
	{
		this.bs.updateBook(book,id);
	}
}
