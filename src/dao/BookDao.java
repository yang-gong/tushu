package dao;

import java.util.List;

import entity.Book;
import entity.Page;

public interface BookDao {
	public List<Book> bookList();
	public int delbookbuid(int id);
	public int addbook(Book book);
	public List<Book> Querybook(String bookName);
	public int updatebook(Book book);
	public Page bookList(Integer pageNo);
	public int getcount();
	}
