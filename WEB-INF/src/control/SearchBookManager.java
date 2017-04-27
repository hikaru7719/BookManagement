//自分が格納されているフォルダ名
package control;

//自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import dao.BookDAO;
import beans.Book;
import java.util.ArrayList;

public class SearchBookManager {
	
	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public SearchBookManager(){
	}

//  検索
	public ArrayList searchBook1(Book book){

		//  BookDAOオブジェクト生成
		BookDAO bookDAO = new BookDAO();
		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = bookDAO.createConnection();
		//  検索する
		ArrayList list = BookDAO.searchBook1(book, this.connection);
		//  DataBaseとの接続を切断する
		dao.BookDAO.closeConnection(this.connection);
		//  コネクションオブジェクトを破棄する
		this.connection = null;
		return list;
	}
	
	//　カテゴリーだけ
	public ArrayList searchBook2(Book book){

		//  BookDAOオブジェクト生成
		BookDAO bookDAO = new BookDAO();
		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = bookDAO.createConnection();
		//  検索する
		ArrayList list = BookDAO.searchBook2(book, this.connection);
		//  DataBaseとの接続を切断する
		dao.BookDAO.closeConnection(this.connection);
		//  コネクションオブジェクトを破棄する
		this.connection = null;
		return list;
	}
}
