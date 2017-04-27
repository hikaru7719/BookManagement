//　自分が格納されているフォルダ名
package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import control.SearchBookManager;

	//HttpServletを継承することで、このクラスはServletとして、働くことができる
	public class SearchServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;

	//  doGetメソッドは使わないので、doPostメソッドへ転送
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		// requestオブジェクトから登録情報の取り出し
		String name = request.getParameter("name");
		String group = request.getParameter("group");
		String number = request.getParameter("number");

		if(number != null) request.setAttribute("number", number);
		//タイトルのみ入力された時
		if(name != "" && group == ""){
		// bookのオブジェクトに情報を格納
        Book book = new Book();
        book.setName(name);
		//  BookManagerオブジェクトの生成
		SearchBookManager manager = new SearchBookManager();
		//  書籍の検索
		ArrayList list = manager.searchBook1(book);
		//  requestオブジェクトにオブジェクトを登録
		request.setAttribute("list", list);
		//  情報表示画面を表示する
		//  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
		getServletContext().getRequestDispatcher("/jsp/Search_list.jsp").forward(request, response);
		}

		else if(name == "" && group != ""){
			// bookのオブジェクトに情報を格納
	        Book book = new Book();
	        book.setGroup(group);
			//  BookManagerオブジェクトの生成
			SearchBookManager manager = new SearchBookManager();
			//  書籍の検索
			ArrayList list = manager.searchBook2(book);
			//  requestオブジェクトにオブジェクトを登録
			request.setAttribute("list", list);
			//  情報表示画面を表示する
			//  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
			getServletContext().getRequestDispatcher("/jsp/Search_list.jsp").forward(request, response);
	   }
		else{
			// bookのオブジェクトに情報を格納
	        Book book = new Book();
	        book.setName(name);
	        book.setGroup(group);
			//  BookManagerオブジェクトの生成
			SearchBookManager manager = new SearchBookManager();
			//  書籍の検索
			ArrayList list = manager.searchBook1(book);
			//  requestオブジェクトにオブジェクトを登録
			request.setAttribute("list", list);
			//  情報表示画面を表示する
			//  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
			getServletContext().getRequestDispatcher("/jsp/Search_list.jsp").forward(request, response);
		}
	}
}