package servlet;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import control.BookManager;

public class RegistServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");

		//getParameterの引数はjspのnameの中身と同じ
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String group = request.getParameter("group");
		String date1 = request.getParameter("date");
		if(name.length()==0 || group.length()==0 || author.length()==0 || date1.length()==0){
			request.setAttribute("error", "項目をすべて入力してください。");
			getServletContext().getRequestDispatcher("/jsp/Regist.jsp").forward(request, response);
		}
		else{

		Date date = Date.valueOf(date1);
		Book book = new Book(0,name,author,group,date,0);

		BookManager manager=new BookManager();


		manager.registBook(book);

			System.out.println("ok");
			response.sendRedirect(response.encodeRedirectURL("./manager_top.jsp"));
		}
	}
}
