package co.simplon.poo.ch10.tp1.service.impl;

import java.util.List;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.ProductRepository;
import co.simplon.poo.ch10.tp1.service.ProductService;

//ici j'implememente mes methodes precedement designé pr pvr les utiliser ds les tests
public class ProductServiceImpl implements ProductService {

	private final ProductRepository products;

	public ProductServiceImpl(ProductRepository products) {
		this.products = products;
	}
		
	@Override
	public void changeMyPrix(String productId, Integer oldPrix, Integer newPrix) throws Exception {
		Product targetProduct = products.getById(productId); 
		if (targetProduct.getPrix().equals(oldPrix)) {
			targetProduct.setPrix(newPrix);
			products.update(targetProduct, productId);
		} else
			throw new Exception("bad old Prix");
		
	}
		
	@Override
	public List<Product> findAllProduct(ProductRepository productRepositoryJson) {
		
		return null;
	}

}
