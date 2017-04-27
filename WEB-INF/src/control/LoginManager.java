package control;

import java.sql.Connection;

import utilities.PasswordEncryption;
import beans.User;
import dao.LoginDAO;

public class LoginManager {
	private Connection connection = null;

	public LoginManager() {
	}

	public User certifyUser(String user_id, String user_pass) {

		//daoの生成
		LoginDAO dao = new LoginDAO();

		this.connection = dao.createConnection();

		//LoginDaoのcertifyメソッドを実行し結果をuserに渡す
		User user = dao.Login( user_id,this.connection);

		dao.closeConnection(this.connection);

		this.connection = null;
		PasswordEncryption pass = new PasswordEncryption();

		if(user==null)
			return null;
		//DBから取得したパスワードと入力されたパスワードが一致するか判別する
		else if(pass.getPassword_encryption(user_pass).equals(user.getPassword()))
		{
			return user;
		}
		else{
			return null;
		}
	}
}
