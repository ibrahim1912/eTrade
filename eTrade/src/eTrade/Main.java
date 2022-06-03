package eTrade;

import eTrade.business.abstracts.ProductService;
import eTrade.business.concretes.ProductManager;
import eTrade.dataAccess.concretes.hibernateImpls.HibernateProductRepository;
import eTrade.entities.concretes.Product;


public class Main {

	public static void main(String[] args) {
		
		ProductService service = new ProductManager(new HibernateProductRepository());
		
		Product product = new Product(1,"Klavye",12,1);
		Product product2 = new Product(20,"Mouse",38,2);
		Product product3 = new Product(7,"Tv",5000,4);
		Product product4 = new Product(7,"Telefon",2000,3);
		
		Product product6 = new Product(1,"Telefon",12,5);
		Product product7 = new Product(20,"Mo",38,5);
		Product product8= new Product(7,"Ty",5000,5);
		Product product9 = new Product(7,"T",-1,5);
		Product product10 = new Product(1,"K",12,5);
		Product product11 = new Product(20,"M",38,5);
		
		
		service.add(product);
		service.add(product2);
		service.add(product3);
		service.delete(product2);
		service.update(product4);
		service.add(product6);
		service.add(product7);
		service.add(product8);
		service.add(product9);
		service.add(product10);
		service.add(product11);
		
		
		
		System.out.println(service.getById(7).getProductName()); 
		
		for (Product item : service.getAll()) {
			System.out.println(item.getProductName());
		}
		
		
		//aynı keteforide en fazla 5 ürün olcak
		//fiyat sıfrdan küçük olamaz
		
		
		
		
	}

}
