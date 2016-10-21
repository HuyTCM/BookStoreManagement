package com.huytcm.bookstore.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "User_Borrow_Book")
public class UserBorrowBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column (name = "id", nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "userId", nullable = false)
	private long userId;
	
	@Column (name = "bookId", nullable = false)
	private long bookId;
	
	@Column (name = "borrowedDate")
	private Calendar borrowedDate;
	
	@Column (name = "returnDate")
	private Calendar returnDate;
	
	@Column (name = "isReturned")
	private Boolean isReturned;

	
	public UserBorrowBook() {
		// TODO Auto-generated constructor stub
	}
	
	public UserBorrowBook(long userId, long bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Calendar getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Calendar borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Calendar getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Calendar returnDate) {
		this.returnDate = returnDate;
	}

	public Boolean getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(Boolean isReturned) {
		this.isReturned = isReturned;
	}
	
}
