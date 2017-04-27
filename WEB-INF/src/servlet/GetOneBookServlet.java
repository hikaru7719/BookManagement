package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import control.GetBookManager;

public class GetOneBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");
		String number2 = (String)request.getParameter("number2");

		int number = Integer.parseInt(request.getParameter("number"));
		if(number2 != null) request.setAttribute("number2", number2);
		GetBookManager manager=new GetBookManager();

		Book book = manager.GetBook(number);
		ArrayList list = manager.GetReserveInfo(number);

		//取得したlistをdiary_listと名付けjspに受け渡せる形にする

		request.setAttribute("book",book);
		request.setAttribute("list",list);
		getServletContext().getRequestDispatcher("/jsp/book_info.jsp").forward(request, response);

	}

}
