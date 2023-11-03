package co.simplon.poo.ch10.layer.repository;

import java.util.List;

//Interface Générique avec T pour le Type d'entité et I pour le type de l'id unique
public interface IGenericCRUDRepository<T> {
	
	void create(T entity); //C
	List<T> retrieve(); //R
	T findById(String id);
	T update(T entity);//U
	void delete(T entity);//D
	void deleteById(String id);
	void deleteAll();
	int count();
}
