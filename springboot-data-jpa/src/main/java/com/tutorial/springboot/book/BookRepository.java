package com.tutorial.springboot.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Book findByName(String name);
	public List<Book> findByAuthorId(Integer id);

}
