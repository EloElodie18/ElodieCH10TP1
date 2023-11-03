package co.simplon.poo.ch10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.layer.model.article.ArticleAlimentaire;
import co.simplon.poo.ch10.layer.repository.impl.ArticleRepository;


public class TestRepository {
	
	private ArticleRepository articles = new ArticleRepository();
	
	
	@BeforeEach
	void clean() {
		//Doit fonctionner quand même :)
		articles.deleteAll();
	}
	
	@Test
	void testCreateArticle() {
		
		ArticleAlimentaire carotte = new ArticleAlimentaire("123", "carotte", 120);
		articles.create(carotte);
		
		assertEquals(1, articles.count());
		assertEquals(articles.retrieve().get(0).getLibelle(), "carotte");
	}
	
	@Test
	void retrieveArticles()	{		
		
		ArticleAlimentaire carotte = new ArticleAlimentaire("123", "carotte", 120);
		ArticleAlimentaire poulet = new ArticleAlimentaire("456", "poulet", 600);
		articles.create(poulet);
		articles.create(carotte);
		
		assertEquals(articles.retrieve().size(),2);
	}
	
	@Test
	void updateArticle()	{		
		fail("Test non implémenté");
	}
	
	@Test
	void deleteArticle()	{		
		fail("Test non implémenté");
	}

}
