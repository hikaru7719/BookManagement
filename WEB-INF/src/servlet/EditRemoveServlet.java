package servlet;
 
 
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import beans.Book;
import control.EditManager;
 
public class EditRemoveServlet extends HttpServlet{
 
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
		
		int number = Integer.parseInt(request.getParameter("number"));
 
		Book book = new Book(number,null,null,null,null,0);
				
		EditManager manager=new EditManager();
 
		manager.removeBook(book);
 
		HttpSession session = request.getSession(true);
		session.removeAttribute("number");
		response.sendRedirect(response.encodeRedirectURL("./manager_top.jsp"));
	}
}