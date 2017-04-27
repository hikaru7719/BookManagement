package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
public class LoginDAO extends DriverAccessor {

	public User Login(String user_id,Connection con){
	try{
		String sql = "select * from profile inner join user on profile.id = user.id where profile.id = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();

		rs.first();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getInt("role"));
		user.setMail_address(rs.getString("mail"));

		pstmt.close();
		rs.close();
		con.close();

		return user;
	}
	catch(SQLException e){
		e.printStackTrace();
		return null;
	}
	}

}
