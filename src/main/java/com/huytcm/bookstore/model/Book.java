package com.huytcm.bookstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.huytcm.bookstore.constant.BookStatus;

@Entity
@Table (name = "Book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "name")
	private String name;
	
	@ManyToMany (mappedBy = "listBook")
	private List<BookCategory> bookCategories = new ArrayList<BookCategory>();
	
	@Column (name = "description", length = 4000)
	private String description;
	
	@ManyToMany (mappedBy="books")
	private List<Author> authors = new ArrayList<Author>();
	
	@Column (name = "publishedDate")
	private Calendar publishedDate;
	
	@Column (name = "status")
	private BookStatus status;
	
	@Column (name = "numOfBorrowed", columnDefinition = "int default '0'")
	private int numOfBorrowed;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookCategory> getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Calendar getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Calendar publishedDate) {
		this.publishedDate = publishedDate;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}
	
}
