package co.simplon.poo.ch10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.layer.model.article.ArticleAlimentaire;
import co.simplon.poo.ch10.layer.model.article.ArticleSport;
import co.simplon.poo.ch10.layer.repository.impl.ArticleRepository;
import co.simplon.poo.ch10.layer.service.IStockService;
import co.simplon.poo.ch10.layer.service.impl.StockService;

public class TestService {

	private IStockService stock = new StockService(new ArticleRepository());
	private final String JSON_FILE = "stockData.json";

	@BeforeEach
	void init() {
		
		stock.effacerTout();
	}

	@Test
	void saveJson() {
		removeFile();

		stock.creerArticle(new ArticleAlimentaire("15", "Truc à manger", 15));
		stock.creerArticle(new ArticleSport("18", "Skate", "Fun sport"));
		stock.sauverJson();
		assertTrue(new File(JSON_FILE).exists());
	}

	@Test
	void loadJson() {
		saveJson();

		stock.chargerJson();
		assertEquals(2, stock.total());

		removeFile();
	}

	private void removeFile() {
		File file = new File(JSON_FILE);
		if (file.exists())
			file.delete();
	}
}
