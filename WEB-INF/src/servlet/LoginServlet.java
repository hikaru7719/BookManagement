package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilities.PasswordEncryption;
import beans.User;
import control.LoginManager;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try{
			//throws ServletException,IOException{
		//文字エンコード
		request.setCharacterEncoding("UTF-8");

		//jspの入力データを取得する
		String user_id=request.getParameter("id");
		String user_pass=request.getParameter("pass");
		if(user_id== null || user_pass==null){
			getServletContext().getRequestDispatcher("/jsp2/login.jsp").forward(request, response);
			return;
		}
		if(user_id.length()==0 || user_pass.length()==0){
			request.setAttribute("error", "項目をすべて入力してください。");
			getServletContext().getRequestDispatcher("/jsp2/login.jsp").forward(request, response);
			return;
		}

		PasswordEncryption pass = new PasswordEncryption();

		System.out.println(user_pass);
		System.out.println(pass.getPassword_encryption(user_pass));

		//managerの生成
		LoginManager manager=new LoginManager();

		//LoginManagerのcertifyメソッドを実行する。
		User user=manager.certifyUser(user_id,user_pass);


		if(null==user){
			request.setAttribute("error", "IDとパスワードをもう一度確認してください");
			getServletContext().getRequestDispatcher("/jsp2/login.jsp").forward(request, response);
		}
		else{
			//ユーザーの情報を保持する
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			if(user.getRole()==1){
				response.sendRedirect(response.encodeRedirectURL("../jsp/manager_top.jsp"));
			}
			else{
			response.sendRedirect(response.encodeRedirectURL("../jsp/user_top.jsp"));
			}
		}

		}catch(ServletException e){
			e.printStackTrace();
		}catch(IOException ioe){
		ioe.printStackTrace();
		}finally{
	}

}
}


