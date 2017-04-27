package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterErrorServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try{
			request.setAttribute("error", "ログインしなおしてください"
					+ "<br>(激おこぷんぷん丸)");
			getServletContext().getRequestDispatcher("/jsp2/login.jsp").forward(request, response);


		}catch(ServletException e){
			e.printStackTrace();
		}catch(IOException ioe){
		ioe.printStackTrace();
		}finally{
	}

}
}
