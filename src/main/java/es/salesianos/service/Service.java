package es.salesianos.service;

import java.util.List;

public interface Service<T> {

	public List<T> listAll();

	public void insert(T formObject);
	
	public void delete(T formObject);
	

}
