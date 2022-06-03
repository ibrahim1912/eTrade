package eTrade.dataAccess.concretes.hibernateImpls;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class HibernateProductRepository implements ProductRepository {

	List<Product> products;
	
	

	public HibernateProductRepository() {
		products= new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
		
		
		
	}

	@Override
	public void update(Product product) {
		Product productToUpdate = getById(product.getId());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setUnitPrice(product.getUnitPrice());
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
