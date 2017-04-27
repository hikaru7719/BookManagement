package control;

import java.sql.Connection;
import java.util.ArrayList;

import beans.Book;
import dao.BookDAO;

public class GetBookManager {

	private Connection connection = null;

	public GetBookManager() {
	}
	public ArrayList GetList() {

		BookDAO dao = new BookDAO();

		this.connection = dao.createConnection();

		ArrayList list = dao.GetList(this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return list;
	}

	public Book GetBook(int number){
		BookDAO dao = new BookDAO();
		this.connection = dao.createConnection();

		Book book = dao.GetBook(number,connection);
		dao.closeConnection(connection);
		this.connection = null;

		return book;
	}

	public ArrayList GetReserveInfo(int number){
		BookDAO dao = new BookDAO();
		this.connection = dao.createConnection();

		ArrayList list = dao.GetReserveInfo(number,connection);
		dao.closeConnection(connection);
		this.connection = null;

		return list;
	}

}