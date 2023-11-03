package co.simplon.poo.ch10.layer.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import co.simplon.poo.ch10.layer.model.article.Article;
import co.simplon.poo.ch10.layer.repository.IGenericCRUDRepository;

public class ArticleRepository implements IGenericCRUDRepository<Article> {

	private static List<Article> articles = new ArrayList<Article>();	

	@Override
	public void create(Article entity) {
		articles.add(entity);		
	}

	@Override
	public List<Article> retrieve() {			
		return Collections.unmodifiableList(articles);
	}

	@Override
	public Article findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article update(Article entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Article entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		articles.clear();

	}

	@Override
	public int count() {
		return articles.size();
	}
}
