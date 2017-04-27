package control;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BookDAO;

public class LendBookManager {
	private Connection connection = null;

	public LendBookManager() {
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
	public String serch_lend_user(int number){
		BookDAO dao = new BookDAO();
		this.connection = dao.createConnection();
		String address = dao.search_lend_user(number,connection);
		dao.closeConnection(this.connection);

		this.connection = null;

		return address;

	}
	
	public void  LendRemoveBook(int number) {

		BookDAO dao = new BookDAO();

		this.connection = dao.createConnection();

		dao.LendRemoveBook(number,this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;

	}



}
