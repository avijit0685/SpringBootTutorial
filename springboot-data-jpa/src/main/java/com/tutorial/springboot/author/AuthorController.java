package com.tutorial.springboot.author;

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
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable Integer id){
		return authorService.getAuthor(id);
	}
	
	@PostMapping("/authors")
	public void createAuthor(@RequestBody Author author){
		authorService.createAuthor(author);
	}
	
	@PutMapping("/authors/{id}")
	public void updateAuthor(@RequestBody Author author,@PathVariable Integer id){
		authorService.updateAuthor(author, id);
	}
	
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable Integer id){
		authorService.deleteAuthor(id);
	}

}
