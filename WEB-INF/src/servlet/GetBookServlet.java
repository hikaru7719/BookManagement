package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.GetBookManager;

public class GetBookServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		request.setCharacterEncoding("UTF-8");


		GetBookManager manager=new GetBookManager();

		ArrayList list = manager.GetList();

		//取得したlistをdiary_listと名付けjspに受け渡せる形にする
	request.setAttribute("book-list",list);
		getServletContext().getRequestDispatcher("/jsp/book_list.jsp").forward(request, response);

	}
}