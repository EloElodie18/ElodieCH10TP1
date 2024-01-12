package co.simplon.poo.ch10.tp1.service;

import java.util.List;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.ProductRepository;
//ici je decris les methodes que je veux utiliser
public interface ProductService {

	List<Product> findAllProduct(ProductRepository productRepositoryJson) throws Exception; //methodes propres à ProductService
	
	void changeMyPrix(String productId, Integer oldPrix, Integer newPrix) throws Exception;
		
}
