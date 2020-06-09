package com.tutorial.springboot.author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.springboot.exception.ResourceNotFoundException;



@Service
public class AuthorService {
	
	/*private List<Author> authors = new ArrayList<>(Arrays.asList(
			new Author("Amish","Tripathi","amish.tripathi@gmail.com", new Date()),
			new Author("Venkat","Naidu","venky.naidu@gmail.com", new Date()),
			new Author("Jeffry","Archer","archer.jeff@gmail.com", new Date())
			));*/
	
	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAllAuthors() {
		List<Author> author = new ArrayList<>();
		authorRepository.findAll().forEach(author::add);		
		return author;
	}

	public Author getAuthor(Integer id) {
		return authorRepository.findById(id).get();
	}

	public void createAuthor(Author author) {
		authorRepository.save(author);
	}

	public void updateAuthor(Author author, Integer id) {
		authorRepository.save(author);
	}

	public void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);		
	}
	

}
