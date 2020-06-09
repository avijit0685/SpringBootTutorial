package com.tutorial.springboot.author;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tutorial.springboot.book.Book;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	private Set<Book> books = new HashSet<>();
	
	protected Author(){
		
	}
	
	public Author(String firstName, String lastName, String email, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/*public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}*/

	@Override
	public String toString() {
		return "Author [authorId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
