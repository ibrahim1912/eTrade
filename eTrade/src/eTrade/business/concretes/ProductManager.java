package eTrade.business.concretes;

import java.util.List;

import eTrade.business.abstracts.ProductService;
import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class ProductManager implements ProductService {

	private ProductRepository repository;

	public ProductManager(ProductRepository repository) {

		this.repository = repository;
	}

	@Override
	public void add(Product product) {

		if (!checkIfNameExists(product.getProductName())) {
			if (product.getUnitPrice() > 0) {
				if (!checkIfCategoryLimit(product.getCategoryId())) {
					repository.add(product);
				} else {
					System.out.println("Bir kategoriye en fazla 5 urun eklenebilir " + product.getProductName());
				}
			} else {
				System.out.println("Urun fiyati 0'dan dusuk olamaz " + product.getProductName() );
			}
		} else {
			System.out.println("Urun ismi ayni olamaz " + product.getProductName());
		}

	}

	@Override
	public void update(Product product) {
		repository.update(product);
		System.out.println("Urun guncellendi : " + product.getProductName());
	}

	@Override
	public void delete(Product product) {
		repository.delete(product);
		System.out.println("Urun silindi : " + product.getProductName());

	}

	@Override
	public List<Product> getAll() {

		return repository.getAll();
	}

	@Override
	public Product getById(int id) {

		return repository.getById(id);
	}

	private boolean checkIfNameExists(String name) {
		boolean exists = false;
		for (Product item : repository.getAll()) {
			if (item.getProductName() == name) {
				exists = true;
			}
		}
		return exists;
	}

	private boolean checkIfCategoryLimit(int categoryId) {
		boolean checkLimit = false;
		int count = 0;
		for (Product item : repository.getAll()) {
			if (item.getCategoryId() == categoryId) {
				count++;
			}
		}

		if (count > 4) {
			checkLimit = true;

		}
		return checkLimit;
	}

}
