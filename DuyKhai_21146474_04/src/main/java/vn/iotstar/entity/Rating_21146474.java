package vn.iotstar.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
@NamedQuery(name = "Rating_21146474.findAll",query = "SELECT r FROM Rating_21146474 r")
public class Rating_21146474 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "BookId")
	private Books_21146474 books;
	
	@ManyToOne
	@JoinColumn(name = "Id")
	private Users_21146474 user;
	
	@Column(name = "rating")
	private byte rating;
	
	@Column(name = "Review_text",columnDefinition = "TEXT")
	private String reviewText;

	public Rating_21146474() {
		
	}

	public Books_21146474 getBooks() {
		return books;
	}

	public void setBooks(Books_21146474 books) {
		this.books = books;
	}

	public Users_21146474 getUser() {
		return user;
	}

	public void setUser(Users_21146474 user) {
		this.user = user;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	
	
}
