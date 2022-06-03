package eTrade.entities.concretes;

public class Product {
	private int id;
	private String productName;
	private double unitPrice;
	private int categoryId;
	
	public Product() {
		super();
	}
	
	public Product(int id, String productName, double unitPrice, int categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
}
