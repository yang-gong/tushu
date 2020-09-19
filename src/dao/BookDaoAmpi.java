package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Book;
import entity.Page;

public class BookDaoAmpi extends BaseDao implements BookDao {

	@Override
	public List<Book> bookList() {
		ResultSet rs = this.executeQuery("select * from book ", null);
		List<Book> list = new ArrayList<Book>();
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				String author = rs.getString(3);
				double price = rs.getDouble(4);
				Book book = new Book();
				book.setId(id);
				book.setBookName(bookname);
				book.setAuothor(author);
				book.setPrice(price);
				list.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return list;
	}

	@Override
	public int delbookbuid(int id) {
		Object[] o = { id };
		int i = this.executUpdate("delete from book where id=?", o);
		this.closeAll();
		return i;
	}

	@Override
	public int addbook(Book book) {
		Object[] o = { book.getBookName(), book.getAuothor(), book.getPrice() };
		int num = this.executUpdate("insert into book (bookName,auothor,price) values (?,?,?) ", o);
		this.closeAll();
		return num;
	}


	@Override
	public int updatebook(Book book) {
		Object[] o = { book.getBookName(), book.getAuothor(), book.getPrice(), book.getId() };
		int num = this.executUpdate("update  book set  bookName=?,auothor=?,price=? where id=? ", o);
		this.closeAll();
		return num;
	}

	@Override
	public Page bookList(Integer pageNo) {
		Page page = new Page();
		page.setCurrPageNo(pageNo);
		page.setTotalCount(this.getcount());
		Object[] o = { (pageNo - 1) * 10, 10 };
		List<Book> list = new ArrayList<Book>();
		ResultSet rs = this.executeQuery("select * from book  limit ?,?", o);
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				double price = rs.getDouble(4);
				Book book = new Book();
				book.setId(id);
				book.setBookName(bookName);
				book.setPrice(price);
				book.setAuothor(author);
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		page.setBookList(list);
		// TODO Auto-generated method stub
		return page;
	}

	@Override
	public Page qubook(String bookName) {
		Page page = new Page();
		int pageNo=1;
		int count =0;
		String bname = "%" + bookName + "%";
		page.setTotalCount(this.getcount());
		Object[] o = {  bname,(pageNo - 1) * 10, 10 };
		List<Book> list = new ArrayList<Book>();

		ResultSet rs = this.executeQuery("select * from book where bookName like ? limit ?,?", o);
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
		     	bookName = rs.getString(2);
				String author = rs.getString(3);
				double price = rs.getDouble(4);
				Book book = new Book();
				book.setId(id);
				book.setBookName(bookName);
				book.setPrice(price);
				book.setAuothor(author);
				list.add(book);
				count++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		page.setBookList(list);
		// TODO Auto-generated method stub
		System.out.println(count);
		page.setTotalCount(count);
		return page;
	}

	@Override
		public List<Book> Querybook(String bookName) {
			int count=0;
			String bname = "%" + bookName + "%";
			Object[] o = { bname };
			List<Book> list = new ArrayList<Book>();
			rs = this.executeQuery("select * from book where bookName like ?", o);
			try {
				while (rs.next()) {
					list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
					count++;
				}
				System.out.println(count);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}


	@Override
	public int getcount() {
		int count=0;
		rs=this.executeQuery("select count(1) from book", null);
		try {
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeAll();
		return count;

	}

}
