package es.salesianos.repository;

import java.util.List;

import es.salesianos.model.Videogame;

public interface Repository<T> {

	void insert(T t);

	void delete(T t);

	void update(T t);

	List<T> searchAll();

	T search(T ObjectInFormulary);

	List<Videogame> searchByRecommendedAge(String recommendedAge);

	List<Videogame> searchByConsole(String consoleName);

	List<Videogame> orderTitles();

}
