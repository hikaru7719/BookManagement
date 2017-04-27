package utilities;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try{
		HttpSession session = ((HttpServletRequest)request).getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			((HttpServletResponse)response).sendRedirect("/BookManagement/jsp2/FilterErrorServlet");
			return ;
		}
		chain.doFilter(request, response);
		}
		catch(ServletException se){
			se.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
