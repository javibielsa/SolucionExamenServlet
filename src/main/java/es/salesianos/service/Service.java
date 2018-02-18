package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public interface Service<T> {

	public T assembleObjectFromRequest(HttpServletRequest req);

	public List<T> listAll();

	public void insert(T formularyObject);
	
	public void delete(T formularyObject);
	

}
