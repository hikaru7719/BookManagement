package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Book;

public class EditDAO extends DriverAccessor{	
	//  情報をデータベースに登録する
	//  引数はBookオブジェクトと、Connectionオブジェクト
	public static void editBook(Book book, Connection connection){

		try{

			System.out.println(connection);
			//  SQLコマンド
			String sql = "update book set name=?,author=?,category=?,date=?,lendstatus=? where number =?";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する

			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getGroup());
			stmt.setDate(4, book.getDate());
			stmt.setInt(5, book.getLendstatus());
			stmt.setInt(6, book.getNumber());

			stmt.executeUpdate();
			stmt.close();

		}catch(SQLException e){

//			エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}

    //  情報をデータベースから削除する
	//  引数はBookオブジェクトと、Connectionオブジェクト
	public static void removeBook(Book book, Connection connection){

		try{

			System.out.println(connection);
			//  SQLコマンド
			String sql = "delete from book where number=?";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する


			stmt.setInt(1, book.getNumber());

			stmt.executeUpdate();
			stmt.close();

		}catch(SQLException e){

//			エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}
}
