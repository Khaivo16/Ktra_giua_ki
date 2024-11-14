package vn.iotstar.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name = "book_author")
@NamedQuery(name = "Book_author_21146474.findAll",query = "SELECT ba FROM Book_author_21146474 ba")
public class Book_author_21146474 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "BookId")
	private Books_21146474 books;
	
	@ManyToOne
	@JoinColumn(name = "AuthorId")
	private Author_21146474 author;

	public Book_author_21146474() {
		
	}

	public Books_21146474 getBooks() {
		return books;
	}

	public void setBooks(Books_21146474 books) {
		this.books = books;
	}

	public Author_21146474 getAuthor() {
		return author;
	}

	public void setAuthor(Author_21146474 author) {
		this.author = author;
	}
	
	
}
