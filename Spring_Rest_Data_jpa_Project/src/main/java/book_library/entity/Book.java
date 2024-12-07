package book_library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Book_master")
public class Book {
	@Id
	@Column(name="book_id")
	private int bookid;
	@Column(name="book_title", length=30)
	private String title;
	@Column(name="book_author", length=30)
	private String author;
	@Column(name="book_price", length=30)
	private float price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, String title, String author, float price) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
