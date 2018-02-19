package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public interface Service<T> {

	public T assembleObjectFromRequest(HttpServletRequest req);

	public List<T> listAll();

	public void insert(T formObject);
	
	public void delete(T formObject);
	

}
