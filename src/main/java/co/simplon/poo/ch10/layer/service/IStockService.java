package co.simplon.poo.ch10.layer.service;

import java.util.List;

import co.simplon.poo.ch10.layer.model.article.Article;

public interface IStockService {
	List<Article> retourneArticles();
	void creerArticle(Article article);
	int total();
	void chargerJson();
	void sauverJson();
	void effacerTout();
}
