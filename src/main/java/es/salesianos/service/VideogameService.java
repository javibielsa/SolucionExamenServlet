package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Videogame;
import es.salesianos.repository.CompanyRepository;
import es.salesianos.repository.VideogameRepository;

@Service
@Profile("database")
public class VideogameService implements es.salesianos.service.Service<Videogame>{
	
	private static Logger log = LogManager.getLogger(VideogameService.class);
	
	@Autowired
	private VideogameRepository repository;

	public void insert(Videogame videogame) {
		log.debug("Insertando el videojuego " + videogame.getTitle());
		repository.insert(videogame);
	}
	
	public void delete(Videogame videogame) {
		log.debug("Borrando el videojuego " + videogame.getTitle());
		repository.delete(videogame);
	}
	
	public List<Videogame> listAll() {
		log.debug("Listando todos los videojuegos...");
		return repository.searchAll();
	}
	
	public List<Videogame> listByRecommendedAge(String recommendedAge) {
		log.debug("Listando videojuegos de edad recomendada " + recommendedAge);
		return repository.searchByRecommendedAge(recommendedAge);
	}
	
	public List<Videogame> listByConsole(String consoleName) {
		log.debug("Listando videojuegos para la consola " + consoleName);
		return repository.searchByConsole(consoleName);
	}
	
	public List<Videogame> order(String recommendedAge, String order) {
		log.debug("Ordenando videojuegos de edad recomendada " + recommendedAge);
		return repository.orderBy(recommendedAge, order);
	}

	


}
