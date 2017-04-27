package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import control.GetBookManager;
import control.LendBookManager;
import utilities.SendMail2;
import control.ReturnManager;

public class ReturnServlet extends HttpServlet {
		public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
			doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			SendMail2 mail = new SendMail2();
			
			int number =Integer.parseInt(request.getParameter("number"));
			int number2=Integer.parseInt(request.getParameter("lend_number"));


			 ReturnManager manager2 = new ReturnManager();
				String address = manager2.serch_lend_user2(number);
				
				 GetBookManager  manager3 = new GetBookManager();
				 Book book = manager3.GetBook(number);

				 mail.Mail(1,book.getName(),address);
			
				LendBookManager manager=new LendBookManager();
				 manager.ReturnBook(number,number2);
				 
				
					 
			 
			getServletContext().getRequestDispatcher("/jsp/LendInfoServlet").forward(request, response);
		}
}