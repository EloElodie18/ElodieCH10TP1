package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.impl.ProductRepositoryJson;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.impl.AdminServiceImpl;
import co.simplon.poo.ch10.tp1.service.impl.ProductServiceImpl;

public class TestProductService {

	private ProductRepositoryJson products = new ProductRepositoryJson("data/json/products.json");
	private ProductServiceImpl productService = new ProductServiceImpl(products);
	
	
	@BeforeEach
	void beforeEachTest() throws IOException { //methode d'initialisation lancé à chq phase de test pour mettre les elements au propre
		products.deleteAll();
	}
	
	@Test
	void changeMyPrix() throws Exception {		
		//je creer 1 produit
		products.create(new Product(8, "jupe"));		
		//je recupère ce produit
		Product jupe = products.getByLogin("jupe");
		//je change le prix de ce produit
		productService.changeMyPrix(jupe.getId(), jupe.getPrix(), 25);
		//je verifie si le nouveau prix est bien prit en compte
		assertEquals(25, products.getByLogin("jupe").getPrix());
		System.out.println(products.getByLogin("jupe").getPrix());
	}
	
	
	
	
	
	
}
