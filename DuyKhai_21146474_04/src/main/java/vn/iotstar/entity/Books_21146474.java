package vn.iotstar.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "books")
@NamedQuery(name = "Books_21146474.findAll",query = "SELECT b FROM Books_21146474 b")
public class Books_21146474 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookId")
	private int bookId;
	
	@Column(name = "isbn")
	private int isbn;
	
	@Column(name = "Title",columnDefinition = "VARCHAR(200) NULL")
	private String title;
	
	@Column(name = "Publisher",columnDefinition = "VARCHAR(100) NULL")
	private String publisher;
	
	@Column(name = "price", columnDefinition = "DECIMAL(6,2)")
	private BigDecimal price;
	
	@Column(name = "Description",columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "Publish_date",columnDefinition = "DATE")
	private LocalDate publish_date;
	
	@Column(name = "Cover_image",columnDefinition = "VARCHAR(100) NULL")
	private String cover_image;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@OneToMany(mappedBy = "books")
	private List<Rating_21146474> rating;
	
	@OneToMany(mappedBy = "books")
	private List<Book_author_21146474> bookAuthor;

	public Books_21146474() {

	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Rating_21146474> getRating() {
		return rating;
	}

	public void setRating(List<Rating_21146474> rating) {
		this.rating = rating;
	}

	public List<Book_author_21146474> getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(List<Book_author_21146474> bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	
	
}
