package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDaoAmpi;
import entity.Book;
import entity.Page;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDaoAmpi bookdao = new BookDaoAmpi();
//	List<Book> list=bookdao.bookList();
//	request.setAttribute("list", list);
		String pagest = request.getParameter("pageNo");
		int pageNo = Integer.parseInt(pagest);
		Page page = new Page();
		if (pageNo < 1) {
			pageNo = pageNo + 1;
		}
		page = bookdao.bookList(pageNo);

		if (pageNo > page.getTotalPageCount()) {
			pageNo = pageNo - 1;
			page = bookdao.bookList(pageNo);
		}
		request.setAttribute("page", page);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
