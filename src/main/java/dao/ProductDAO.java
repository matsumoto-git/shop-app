package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:~/desktop/h2/shop";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Product> findAll() {
		List<Product> productList = new ArrayList<>();
//		JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
//		データベースに接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
//			SELECT文を準備
			String sql = "SELECT ID,NAME,DESCRIPTION,PRICE,IMAGE_PATH,STOCK,GENRE_ID FROM PRODUCTS ORDER BY ID ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
//			セレクト文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

//			結果表に格納されたレコードの内容を
//			Productインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String description = rs.getString("DESCRIPTION");
				int price = rs.getInt("price");
				String imagePath = rs.getString("IMAGE_PATH");
				int stock = rs.getInt("stock");
				int genreId = rs.getInt("genre_id");

				Product product = new Product(id, name, description, price, imagePath);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return productList;
	}
	
	public Product findById(int id) {
		  Product product = null;
		  try {
		    Class.forName("org.h2.Driver");
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setInt(1, id);
		      ResultSet rs = pStmt.executeQuery();

		      if (rs.next()) {
		        String name = rs.getString("name");
		        String description = rs.getString("description");
		        int price = rs.getInt("price");
		        String imagePath = rs.getString("image_path");
		        int stock = rs.getInt("stock");
		        int genreId = rs.getInt("genre_id");

		        product = new Product(id, name, description, price, imagePath);
		        // 必要なら stock, genreId もセット
		      }
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return product;
		}

//	public boolean create(Mutter mutter) {
//		try {
//			Class.forName("org.h2.Driver");
//		} catch (ClassNotFoundException e) {
//			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
//		}
//		try (Connection conn = DriverManager.getConnection(
//				JDBC_URL, DB_USER, DB_PASS)) {
//
//			String sql = "INSERT INTO MUTTERS(NAME, TEXT) VALUES(?, ?)";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			pStmt.setString(1, mutter.getUserName());
//			pStmt.setString(2, mutter.getText());
//
//			int result = pStmt.executeUpdate();
//			if (result != 1) {
//				return false;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

}
