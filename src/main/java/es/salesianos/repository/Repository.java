package es.salesianos.repository;

import java.util.List;

public interface Repository<T> {
	
	public static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insert(T t);

	public void delete(T t);

	public List<T> searchAll();

	public T search(T objectInFormulary);

}
