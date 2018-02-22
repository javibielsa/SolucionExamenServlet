package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

@Service
@Profile("database")
public class ConsoleService implements es.salesianos.service.Service<Console>{
	
	private static Logger log = LogManager.getLogger(ConsoleService.class);
	
	@Autowired
	private ConsoleRepository repository;
	
	public void insert(Console console) {
		log.debug("Insertando la consola " + console.getName());
		repository.insert(console);
	}
	
	public void delete(Console console) {
		log.debug("Borrando la consola " + console.getName());
		repository.delete(console);
	}
	
	public List<Console> listAll(){
		log.debug("Listando todas las consolas...");
		return repository.searchAll();
	}
	
	public List<Console> listByCompany(String companyName){
		log.debug("Listando todas las consolas de la empresa " + companyName);
		return repository.searchByCompany(companyName);
	}


}
