package test;

import java.util.List;

import dao.BookDaoAmpi;
import entity.Book;

public class Test {
	public static void main(String[] args) {
		BookDaoAmpi bookDao = new BookDaoAmpi();
		//List<Book> bookList = bookDao.bookList();
		//System.out.println(bookList);
	//System.out.println( bookDao.bookList());
//	System.out.println(bookDao.getcount());
		System.out.println(bookDao.Querybook("图书"));

		System.out.println(bookDao.qubook("图书"));

	}
}
