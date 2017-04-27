package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.LendBookManager;

public class LendInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{



		request.setCharacterEncoding("UTF-8");

		LendBookManager manager=new LendBookManager();

		 ArrayList list= manager.LendBookinfo();



		 request.setAttribute("list",list);
		getServletContext().getRequestDispatcher("/jsp/lned_info.jsp").forward(request, response);

	}

}
