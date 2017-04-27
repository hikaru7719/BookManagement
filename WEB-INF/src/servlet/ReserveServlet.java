package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilities.SendMail;
import beans.Book;
import beans.User;
import control.GetBookManager;
import control.LendBookManager;
import control.ReserveManager;

public class ReserveServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

		//文字エンコード
		request.setCharacterEncoding("UTF-8");

		SendMail mail = new SendMail();


		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");


	int number = Integer.parseInt(request.getParameter("number"));

		LendBookManager manager = new LendBookManager();
		String address = manager.serch_lend_user(number);
		GetBookManager mana = new GetBookManager();


		ReserveManager manager2=new ReserveManager();

		 manager2.ReserveBook(number,user.getId());


		 GetBookManager  manager3 = new GetBookManager();
		 Book book = manager3.GetBook(number);
		 ArrayList list = manager3.GetReserveInfo(number);

		 mail.Mail(1,book.getName(),address);


		 request.setAttribute("book",book);
		 request.setAttribute("list",list);
		 System.out.println("ok");
		getServletContext().getRequestDispatcher("/jsp/book_info.jsp").forward(request, response);
	}

}
