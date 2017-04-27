package control;

import java.sql.Connection;

import dao.BookDAO;

public class ReserveManager {
	private Connection connection = null;

	public ReserveManager() {
	}
	public void ReserveBook(int number,String id) {

		BookDAO dao = new BookDAO();

		this.connection = dao.createConnection();

		  dao.ReserveBook(number,id,connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return ;
	}
}
