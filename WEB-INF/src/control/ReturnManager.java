package control;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;

public class ReturnManager {
	private Connection connection = null;

	public ReturnManager() {
	}
	public void LendBook(int number,String id) {

		BookDAO dao = new BookDAO();

		this.connection = dao.createConnection();

		  dao.LendBook(number,id,connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return ;
	}
	public ArrayList  LendBookinfo() {

		BookDAO dao = new BookDAO();

		this.connection = dao.createConnection();

		  ArrayList list = dao.LendBookinfo(this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

		return list;
	}

	public void  ReturnBook(int number,int number2) {

		BookDAO dao = new BookDAO();

		this.connection = dao.createConnection();

		dao.ReturnBook(number,number2,this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

	}
	public String serch_lend_user2(int number){
		BookDAO dao = new BookDAO();
		this.connection = dao.createConnection();
		String address = dao.search_lend_user2(number,connection);
		dao.closeConnection(this.connection);

		this.connection = null;

		return address;

	}



}
