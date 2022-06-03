package eTrade.dataAccess.concrete.jdbcImpls;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class JdbcProductRepository implements ProductRepository {

	List<Product> products;
	
	public JdbcProductRepository() {
		products = new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
		
	}

	@Override
	public void update(Product product) {
		Product productToUpdate = getById(product.getId());
		productToUpdate.setCategoryId(productToUpdate.getCategoryId());
		productToUpdate.setProductName(productToUpdate.getProductName());
		productToUpdate.setUnitPrice(productToUpdate.getUnitPrice());
	}	
		

	@Override
	public void delete(Product product) {
		products.remove(getById(product.getId()));
		
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

	@Override
	public Product getById(int id) {
		Product findToProduct = null;
		for (Product product : products) {
			if(product.getId() == id) {
				findToProduct = product;
			}
		}
		return findToProduct;
	}

}
