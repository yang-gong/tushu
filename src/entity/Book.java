package entity;

public class Book {
	private int id;
	private String bookName;
	private String auothor;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuothor() {
		return auothor;
	}

	public void setAuothor(String auothor) {
		this.auothor = auothor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book(String bookName, String auothor, double price) {
		super();
		this.bookName = bookName;
		this.auothor = auothor;
		this.price = price;
	}

	public Book(int id, String bookName, String auothor, double price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.auothor = auothor;
		this.price = price;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", auothor=" + auothor + ", price=" + price + "]";
	}

}
