package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoAmpi;
import entity.User;

/**
 * Servlet implementation class Regservlet
 */
@WebServlet("/regservlet")
public class Regservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Regservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User us=new User(username,password);
		UserDaoAmpi userdao=new UserDaoAmpi();
		boolean b=userdao.QueryUser(username);
		if (b==false)
		{
			userdao.adduser(us);
			request.getRequestDispatcher("regss.jsp").forward(request, response);
		}else {
			response.sendRedirect("regf.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
