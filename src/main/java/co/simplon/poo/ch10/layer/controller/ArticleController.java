package co.simplon.poo.ch10.layer.controller;

import java.util.Random;
import java.util.Scanner;

import co.simplon.poo.ch10.layer.model.article.Article;
import co.simplon.poo.ch10.layer.model.article.ArticleAlimentaire;
import co.simplon.poo.ch10.layer.model.article.ArticleSport;
import co.simplon.poo.ch10.layer.repository.impl.ArticleRepository;
import co.simplon.poo.ch10.layer.service.IStockService;
import co.simplon.poo.ch10.layer.service.impl.StockService;

public class ArticleController {

	private static IStockService stock = new StockService(new ArticleRepository());

	public static void main(String[] args) {

		// Menu type Console avec switch case
		String choice = null;
		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();
		do {
			choice = scan.nextLine();
			switch (choice) {
			case "c": {
				// creation aléatoire
				Article trucAleatoire = null;
				if (rnd.nextInt() % 2 == 0) {
					trucAleatoire = new ArticleAlimentaire(String.valueOf(rnd.nextInt()), "Truc Aléatoire",
							rnd.nextInt());
				} else {
					trucAleatoire = new ArticleSport(String.valueOf(rnd.nextInt()), "Truc Aléatoire", "Un sport");
				}

				stock.creerArticle(trucAleatoire);

				break;
			}
			case "r": {
				for (Article article : stock.retourneArticles()) {
					System.out.println(article);
				}
				break;
			}
			case "u": {
				// Update
				break;
			}
			case "d": {
				// Delete one
				break;
			}
			case "da": {
				// delete All

				break;
			}
			
			case "s": {
				// save

				break;
			}
			
			case "l": {
				// load

				break;
			}

			}
		} while (!choice.equals("q"));

		scan.close();
	}
}
