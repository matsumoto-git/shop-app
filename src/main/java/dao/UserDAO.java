package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:~/desktop/h2/shop";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public User findByEmailAndPassword(String email, String password) {
//		JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
//		データベースに接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
//			セレクト文を準備
			String sql = "select * from users where email = ? and password = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, email);
			pStmt.setString(2, password);
//			セレクト文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean isAdmin = rs.getBoolean("is_admin");
				return new User(id, name, email, password, isAdmin);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

