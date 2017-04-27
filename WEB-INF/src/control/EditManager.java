//自分が格納されているフォルダ名
package control;

//自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import dao.EditDAO;
import beans.Book;

public class EditManager {

	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public EditManager(){
	}

	//  再登録する
	//  引数はBookオブジェクト
	public void editBook(Book book){

		//  BookDAOオブジェクト生成
		EditDAO editDAO = new EditDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = editDAO.createConnection();

		//  BookオブジェクトをDataBaseに登録する
		EditDAO.editBook(book, this.connection);

		//  DataBaseとの接続を切断する
		EditDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

    //  削除する
	//  引数はBookオブジェクト
	public void removeBook(Book book){

		//  BookDAOオブジェクト生成
		EditDAO editDAO = new EditDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = editDAO.createConnection();

		//  BookオブジェクトをDataBaseに登録する
		EditDAO.removeBook(book, this.connection);

		//  DataBaseとの接続を切断する
		EditDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}
}
