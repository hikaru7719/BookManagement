package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAccessor {
	private final static String DRIVER_URL="jdbc:mysql://localhost:3306/management?useUnicode=true&characterEncoding=Windows-31J";

	private final static String DRIVER_NAME="com.mysql.jdbc.Driver";

	//自分のmysqlのユーザー名
	private final static String USER_NAME="book";
    //自分のmysqlのパスワード
	private final static String PASSWORD="book";



	public Connection createConnection(){
	try{
		Class.forName(DRIVER_NAME);
		Connection con=DriverManager.getConnection(DRIVER_URL,USER_NAME,PASSWORD);
		return con;


		}catch(ClassNotFoundException e){


			System.out.println("Can't Find JDBC Driver.\n");

			}catch(SQLException e){
					System.out.println(e.getErrorCode());
					 System.out.println("Connection Error.\n");
					 e.printStackTrace();

			}
	return null;

	}


	public static void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception ex){}
	}

}
