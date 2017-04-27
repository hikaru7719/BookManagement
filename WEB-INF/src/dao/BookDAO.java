package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Book;
import beans.LendInfo;
import beans.ReserveInfo;

public class BookDAO extends DriverAccessor{

	public ArrayList GetList(Connection connection){

		try{
			String sql="select * from book ";

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			ArrayList list = new ArrayList();

			//登録されている商品の数だけ繰り返す
			while(rs.next())
			{
				Book book = new Book();
				book.setNumber( rs.getInt("number") );
				book.setName( rs.getString("name") );
				book.setAuthor( rs.getString("author"));
				book.setGroup( rs.getString("category") );
				book.setDate( rs.getDate("date") );
				book.setLendstatus( rs.getInt("lendstatus"));
				list.add(book);
			}

			stmt.close();
			rs.close();

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

		}finally{
		}
	}
	public Book GetBook(int number,Connection connection){
		try{
			String sql="select * from book where number = ?";
			PreparedStatement stmt =connection.prepareStatement(sql);
			stmt.setInt(1, number);

			ResultSet rs = stmt.executeQuery();

			rs.first();

			Book book = new Book();
			book.setNumber( rs.getInt("number") );
			book.setName( rs.getString("name") );
			book.setAuthor( rs.getString("author"));
			book.setGroup( rs.getString("category") );
			book.setDate( rs.getDate("date") );
			book.setLendstatus( rs.getInt("lendstatus"));

			stmt.close();
			rs.close();

			return book;

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{

		}
	}
	public ArrayList  GetReserveInfo(int number,Connection con){
		try{
			String sql="select * from reserve_book where book_number = ? and reserve_status = 1";
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setInt(1, number);

			ResultSet rs = stmt.executeQuery();
			ArrayList list = new ArrayList();
			BookDAO dao = new BookDAO();
			while(rs.next()){

			ReserveInfo info = new ReserveInfo();
			info.setNumber( rs.getInt("reserve_book_number") );
			info.setUser_id( rs.getString("user_id") );
			info.setBook_number( rs.getInt("book_number"));
			info.setReserve_status( rs.getInt("reserve_status") );
			String name =dao.GetName(info.getUser_id(), con);
			list.add(info);
			list.add(name);
			}


			stmt.close();
			rs.close();
			if(list.isEmpty())	{
				ReserveInfo info = new ReserveInfo();
				list.add(info);
			}

			return list;
	}catch(SQLException e){
		e.printStackTrace();
		ArrayList list = new ArrayList();
		ReserveInfo info = new ReserveInfo();
		list.add(info);
		return list;
	}


	}
	public void LendBook(int number,String id,Connection connection){
		try{
			String sql1 = "update book set lendstatus = 1 where number = ?";


			PreparedStatement pstmt1 = connection.prepareStatement(sql1);
			pstmt1.setInt(1,number);

			pstmt1.executeUpdate();
			pstmt1.close();
			String sql2 = "insert into lend_book (book_number,user_id,day,status) values (?,?,now(),1)";
			PreparedStatement pstmt2 = connection.prepareStatement(sql2);
			pstmt2.setInt(1, number);
			pstmt2.setString(2, id);
			pstmt2.executeUpdate();
			pstmt2.close();

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();

		}
	}

	public void ReserveBook(int number,String id,Connection connection){
		try{
			String sql2 = "insert into reserve_book (book_number,user_id,reserve_status) values (?,?,1)";
			PreparedStatement pstmt2 = connection.prepareStatement(sql2);
			pstmt2.setInt(1, number);
			pstmt2.setString(2, id);
			pstmt2.executeUpdate();
			pstmt2.close();

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();

		}
	}
	public ArrayList LendBookinfo(Connection connection){
		try{
			String sql = "select *from lend_book  inner join book on lend_book.book_number = book.number where lend_book.status = 1";


			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs=stmt.executeQuery();

			ArrayList list = new ArrayList();
			BookDAO dao = new BookDAO();


			while(rs.next())
			{
				LendInfo info = new LendInfo();
				info.setNumber( rs.getInt("lend_book_number") );
				info.setUser_id( rs.getString("user_id") );
				info.setBook_number( rs.getInt("book_number"));
				info.setDate( rs.getDate("date") );
				Book book = dao.GetBook(info.getBook_number(),connection);
				String name = dao.GetName(info.getUser_id(),connection);
				list.add(info);
				list.add(book.getName());
				list.add(name);

			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	public String GetName(String id,Connection connection){
		try{
			String sql="select name from profile where id = ?";
			PreparedStatement stmt =connection.prepareStatement(sql);
			stmt.setString(1,id );

			ResultSet rs = stmt.executeQuery();

			rs.first();

			String name = rs.getString("name");

			stmt.close();
			rs.close();

			return name;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{

		}

	}
	public void ReturnBook(int number,int number2,Connection connection){
		try{
			String sql = "update book set lendstatus = 0 where number = ?";


			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,number);

			pstmt.executeUpdate();
			pstmt.close();
			String sql2 = "update lend_book set status = 0 where lend_book_number = ?";


			PreparedStatement pstmt2 = connection.prepareStatement(sql2);
			pstmt2.setInt(1,number2);

			pstmt2.executeUpdate();
			pstmt2.close();
			connection.close();

		}catch(SQLException e){
			e.printStackTrace();

		}
	}

	//  情報をデータベースに登録する
	//  引数はBookオブジェクトと、Connectionオブジェクト
	public static void registBook(Book book, Connection connection){

		try{

			System.out.println(connection);
			//  SQLコマンド
			String sql = "insert into book (name,author,category,date,lendstatus) values (?, ?, ?, ?, ?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する

			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getGroup());
			stmt.setDate(4, book.getDate());
			stmt.setInt(5, book.getLendstatus());

			stmt.executeUpdate();
			stmt.close();

		}catch(SQLException e){

//			エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}


	  //  検索する(タイトルのみ/どちらも入力)
	  //引数はBookオブジェクトと、Connectionオブジェクト
	public static ArrayList searchBook1(Book book, Connection connection){

		try{
			//  SQLコマンド
			//*の意味はすべてのカラム
			String sql = "select * from book where name = '" + book.getName() + "'";

			//  SQLのコマンドを実行する
			//  実行結果はrsに格納される
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);


			ArrayList list = new ArrayList();

			while(rs.next())
			{
				Book book1 = new Book();
				book1.setNumber( rs.getInt("number") );
				book1.setName( rs.getString("name") );
				book1.setAuthor( rs.getString("author"));
				book1.setGroup( rs.getString("category") );
				book1.setDate( rs.getDate("date") );
				book1.setLendstatus( rs.getInt("lendstatus"));
				list.add(book1);
			}



			//  終了処理
			stmt.close();
			rs.close();
			//  Bookオブジェクトを返す
			return list;

			}catch(SQLException e){
				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;
			}finally{
			}
	}
	public static ArrayList searchBook2(Book book ,Connection connection){

		try{
			String sql="select * from book where category = '" + book.getGroup() + "'";

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();

			ArrayList list = new ArrayList();

			while(rs.next())
			{

				Book book1 = new Book();
				book1.setNumber( rs.getInt("number") );
				book1.setName( rs.getString("name") );
				book1.setAuthor( rs.getString("author"));
				book1.setGroup( rs.getString("category") );
				book1.setDate( rs.getDate("date") );
				book1.setLendstatus( rs.getInt("lendstatus"));
				list.add(book1);
			}

			stmt.close();
			rs.close();

			return list;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

		}finally{
		}
	}
	public String search_lend_user( int number ,Connection connection){

		try{
			String sql="select user_id from lend_book where book_number = ? and status = 1";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, number);
			ResultSet rs=stmt.executeQuery();
			rs.first();

			String id = rs.getString("user_id");
			String sql2 ="select mail from profile where id = ?";
			PreparedStatement stmt2 = connection.prepareStatement(sql2);
			stmt2.setString(1, id);
			ResultSet rs2 = stmt2.executeQuery();
			rs2.first();
			String address =rs2.getString("mail");


			stmt.close();
			rs.close();

			return address;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

		}finally{
		}
	}
	public String search_lend_user2( int number ,Connection connection){

		try{
			String sql="select user_id from reserve_book where book_number = ? and reserve_status = 1";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, number);
			ResultSet rs=stmt.executeQuery();
			rs.first();

			String id = rs.getString("user_id");
			String sql2 ="select mail from profile where id = ?";
			PreparedStatement stmt2 = connection.prepareStatement(sql2);
			stmt2.setString(1, id);
			ResultSet rs2 = stmt2.executeQuery();
			rs2.first();
			String address =rs2.getString("mail");


			stmt.close();
			rs.close();

			return address;

		}catch(SQLException e){

			e.printStackTrace();

			return null;

		}finally{
		}
	}
	public void LendRemoveBook(int number,Connection connection){
		try{
			String sql = "update reserve_book set reserve_status = 0 where reserve_book_number = ?";


			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,number);

			pstmt.executeUpdate();
			pstmt.close();

			connection.close();

		}catch(SQLException e){
			e.printStackTrace();

		}
	}

}
