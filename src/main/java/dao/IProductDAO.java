package dao;

import java.util.List;

import entity.Product;

public interface IProductDAO {
	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	boolean addProduct(Product product);
	
	boolean updateProduct(Product product);
	
	boolean deleteProduct(int id);
}