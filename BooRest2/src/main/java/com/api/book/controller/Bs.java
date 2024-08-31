package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepo;
import com.api.book.entity.Book;
@Service
public class Bs {

	@Autowired
	BookRepo br;
	
	public Book getBookById1(int id)
	{
		Book b = this.br.findById(id);
		return b;
	}
	
	public List<Book> getAllBooks()
	{
		List<Book> list = (List<Book>) this.br.findAll();
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book=null;
		try {
			
			// book = books.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.br.findById(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
		
	}
	
	public Book addBook(Book book) {
		Book result = br.save(book);
		return result;
		
	}
	
	public void deleteBook(int id)
	{
		//books = books.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		 
		br.deleteById(id);
	}

	public void updateBook(Book book, int id) {
//		books = books.stream().map(b->{
//			if(b.getId()==id)
//			{
//				b.setAuthor(book.getAuthor());
//				b.setName(book.getName());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		br.save(book);
	}
}
