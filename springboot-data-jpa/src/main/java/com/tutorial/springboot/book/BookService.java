package com.tutorial.springboot.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.springboot.author.Author;
import com.tutorial.springboot.author.AuthorService;



@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorService authorService;

	public List<Book> getAllBooks(Integer author_id) {
		return bookRepository.findByAuthorId(author_id);
	}

	public Book getBook(Integer id) {
		return bookRepository.findById(id).get();
	}
	
	public Book getBookByName(String name) {
		return bookRepository.findByName(name);
	}

	public void addBook(Book book, Integer author_id) {
		Author author = authorService.getAuthor(author_id);
		book.setAuthor(author);
		bookRepository.save(book);
	}

	public void updateBook(Book book, Integer author_id, Integer book_id) {
		Author author = authorService.getAuthor(author_id);
		book.setAuthor(author);
		bookRepository.save(book);
	}

	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);		
	}

	public Book getBookByName(Integer author_id, String book_name) {
		return bookRepository.findByName(book_name);
	}

	

}
