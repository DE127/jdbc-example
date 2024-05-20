package entity;

public class Product {
	private int product_id;
	private String product_name;
	private double price;
	private int stock_quantity;
	private int category_id;
	private String image;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int product_id, String product_name, double price, int stock_quantity, int category_id,
			String image) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.category_id = category_id;
		this.image = image;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
