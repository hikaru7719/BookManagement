//自分が格納されているフォルダ名
package control;

//自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import dao.BookDAO;
import beans.Book;

public class BookManager {

	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public BookManager(){
	}

	//  追加する
	//  引数はBookオブジェクト
	public void registBook(Book book){

		//  BookDAOオブジェクト生成
		BookDAO bookDAO = new BookDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = bookDAO.createConnection();

		//  BookオブジェクトをDataBaseに登録する
		BookDAO.registBook(book, this.connection);

		//  DataBaseとの接続を切断する
		BookDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

}
