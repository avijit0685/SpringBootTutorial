package com.tutorial.springboot.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/authors/{author_id}/books")
	public List<Book> getAllBooks(@PathVariable Integer author_id){
		return bookService.getAllBooks(author_id);
	}
	
	/*@GetMapping("/authors/{author_id}/books/{book_name}")
	public Book getBookByAuthor(@PathVariable Integer author_id, @PathVariable String book_name){
		return bookService.getBookByName(author_id,book_name);
	}*/
	
	@GetMapping("/authors/{author_id}/books/{book_id}")
	public Book getBookByAuthor(@PathVariable Integer author_id, @PathVariable Integer book_id){
		return bookService.getBook(book_id);
	}
	
	@PostMapping("/authors/{author_id}/books")
	public void createBook(@RequestBody Book book, @PathVariable Integer author_id){
		bookService.addBook(book, author_id);
	}
	
	@PutMapping("/authors/{author_id}/books/{book_id}")
	public void updateBook(@RequestBody Book book,@PathVariable Integer author_id, @PathVariable Integer book_id){
		bookService.updateBook(book, author_id, book_id);
	}
	
	@DeleteMapping("/authors/{author_id}/books/{book_id}")
	public void deleteBook(@PathVariable Integer author_id, @PathVariable Integer book_id){
		bookService.deleteBook(book_id);
	}
	

}
