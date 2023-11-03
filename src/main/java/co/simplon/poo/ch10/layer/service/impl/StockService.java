package co.simplon.poo.ch10.layer.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

import co.simplon.poo.ch10.layer.model.article.Article;
import co.simplon.poo.ch10.layer.repository.impl.ArticleRepository;
import co.simplon.poo.ch10.layer.service.IStockService;

public class StockService implements IStockService {

	private ArticleRepository articles;
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	// Dans ce programme on part sur un ficheir JSON par repository
	private final String JSON_FILENAME = "stockData.json";

	public StockService(ArticleRepository articleRepository) {
		this.articles = articleRepository;
	}

	@Override
	public List<Article> retourneArticles() {
		return articles.retrieve();
	}

	@Override
	public void creerArticle(Article article) {
		articles.create(article);
	}
	
	@Override
	public int total() {		
		return articles.count();
	}
	
	@Override
	public void effacerTout() {
		this.articles.deleteAll();		
	}

	@Override
	public void chargerJson() {
		try {
			List<Article> temp = new ArrayList<Article>();
			temp = objectMapper.readValue(new File(JSON_FILENAME), new TypeReference<List<Article>>() {
			});
			
			effacerTout();		
			
			for (Article article : temp) {
				this.articles.create(article);
			}

		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sauverJson() {
		try {
			List<Article> temp = new ArrayList<Article>();
			temp = this.articles.retrieve();
			objectMapper.activateDefaultTyping(new LaissezFaireSubTypeValidator(),
					ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
			objectMapper.writeValue(new File(JSON_FILENAME), temp);

		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	
}
