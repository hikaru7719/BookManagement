package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;
import beans.User;
import control.GetBookManager;
import control.LendBookManager;


public class LendServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");


	int number = Integer.parseInt(request.getParameter("number"));


		LendBookManager manager=new LendBookManager();

		 manager.LendBook(number,user.getId());

		 GetBookManager  manager1 = new GetBookManager();
		 Book book = manager1.GetBook(number);
		 ArrayList list = manager1.GetReserveInfo(number);



		 request.setAttribute("book",book);
		 request.setAttribute("list", list);
		 System.out.println("ok");
		getServletContext().getRequestDispatcher("/jsp/book_info.jsp").forward(request, response);

	}

}
