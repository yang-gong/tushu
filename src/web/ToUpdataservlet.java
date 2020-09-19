package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDaoAmpi;
import entity.Book;

/**
 * Servlet implementation class ToUpdataservlet
 */
@WebServlet("/toUpdataservlet")
public class ToUpdataservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdataservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idstring= request.getParameter("id");	
		int id = Integer.parseInt(idstring);
		String bookName =request.getParameter("bookName");
		String auothor =request.getParameter("auothor");	
    	String pricestring =request.getParameter("price");
    	double price = Double.parseDouble (pricestring);
    
    	request.getRequestDispatcher("tobook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
