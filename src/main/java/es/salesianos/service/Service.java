package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public interface Service<T> {

	T assembleObjectFromRequest(HttpServletRequest req);

	List<T> listAll();

	void insertOrUpdate(T ObjectInFormulary);

	List<T> listByCompany(String companyName);

	List<T> listByConsole(String consoleName);

	List<Videogame> listByRecommendedAge(String parameter);

	List<Videogame> orderByTitle();
	

}
