package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.impl.ProductRepositoryJson;

public class TestProductRepository {

	private ProductRepositoryJson products = new ProductRepositoryJson("data/json/products.json");
	
	@BeforeEach
	void beforeEachTest() throws IOException {
		products.deleteAll();
	}
	
	@Test
	void testCreateAndRetrieve() throws IOException {
		products.create(new Product(5, "jupe"));
		products.create(new Product(10, "short"));
		List<Product> testList = products.retrieve(); 
		assertEquals(2, testList.size());
	}	

	@Test
	void testDelete() throws IOException {
		Product robe = products.create(new Product(25, "robe"));//creation d'un produit
		assertEquals(1, products.count()); //test pr verifier s'il y a bien 1 prdt dans la liste

		try {
			products.delete(robe.getId()); //suppression du produit
			assertEquals(0, products.count()); //test pr verifier si la liste est bien vide
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
	}
	
	@Test
	void testFindByLogin() throws IOException { // test pr verifier un user par son login
		products.create(new Product(75, "ceinture"));
		products.create(new Product(140, "chaussures"));

		assertNotNull(products.getByLogin("ceinture"));
		assertNotNull(products.getByLogin("chaussures"));
		assertNull(products.getByLogin("Sainture")); 
		assertNull(products.getByLogin("Chaussures"));
	}
	
//	@Test LA PASSER EN STRING PR QUE CA PASSE
//	void testFindById() throws IOException { //test pr verifier si l'user correspond à l'id
//		String id = products.create(new Product(200, "sac").getId());
//		assertEquals("sac", products.getById(id).getLogin()); //test pr savoir si l'id correspond bien à stef
//	}
	
	
}
