package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ImplProductDAO {
	
	private Connection mCnn;
	
	public ImplProductDAO() {
		mCnn = DatabaseHelper.getConnection();
	}
	
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM products";
		try {
			Statement stm = mCnn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setStock_quantity(rs.getInt("stock_quantity"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setImage(rs.getString("image"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Product getProductById(int id) {
		Product product = new Product();
		String sql = "SELECT * FROM products WHERE product_id = " + id;
		try {
			Statement stm = mCnn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				product.setStock_quantity(rs.getInt("stock_quantity"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public boolean addProduct(Product product) {
		String sql = "INSERT INTO products(product_name, price, stock_quantity, category_id, image) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstm = mCnn.prepareStatement(sql);
			pstm.setString(1, product.getProduct_name());
			pstm.setDouble(2, product.getPrice());
			pstm.setInt(3, product.getStock_quantity());
			pstm.setInt(4, product.getCategory_id());
			pstm.setString(5, product.getImage());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateProduct(Product product) {
		String sql = "UPDATE products SET product_name = ?, price = ?, stock_quantity = ?, category_id = ?, image = ? WHERE product_id = ?";
		try {
			PreparedStatement pstm = mCnn.prepareStatement(sql);
			pstm.setString(1, product.getProduct_name());
			pstm.setDouble(2, product.getPrice());
			pstm.setInt(3, product.getStock_quantity());
			pstm.setInt(4, product.getCategory_id());
			pstm.setString(5, product.getImage());
			pstm.setInt(6, product.getProduct_id());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteProduct(int id) {
		String sql = "DELETE FROM products WHERE product_id = ?";
		try {
			PreparedStatement pstm = mCnn.prepareStatement(sql);
			pstm.setInt(1, id);
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
