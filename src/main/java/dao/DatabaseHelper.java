package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static Connection mCnn;

	private DatabaseHelper() {
	}
	
	public static Connection getConnection() {
		if (mCnn == null) {
			// Mở kết nối
			try {
				// 1. Nạp thư viện
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2. Khởi tạo đối tượng Connection
				mCnn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				System.out.println("Lỗi nạp thư viện: " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Lỗi kết nối csdl: " + e.getMessage());
				e.printStackTrace();
			}

		}

		return mCnn;
	}
}
