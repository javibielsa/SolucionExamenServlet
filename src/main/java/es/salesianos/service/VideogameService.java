package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.Assembler;
import es.salesianos.assembler.VideogameAssembler;
import es.salesianos.model.Videogame;
import es.salesianos.repository.VideogameRepository;

public class VideogameService implements Service<Videogame>{
	
	private VideogameRepository repository = new VideogameRepository();
	private Assembler<Videogame> assembler = new VideogameAssembler();

	public Videogame assembleObjectFromRequest(HttpServletRequest req) {
		return assembler.assembleObjectFrom(req);
	}

	public void insert(Videogame formularyVideogame) {
		repository.insert(formularyVideogame);
	}
	
	public void delete(Videogame formularyVideogame) {
		repository.delete(formularyVideogame);
	}
	
	public List<Videogame> listAll() {
		return repository.searchAll();
	}
	
	public List<Videogame> listByRecommendedAge(String recommendedAge) {
		return repository.searchByRecommendedAge(recommendedAge);
	}
	
	public List<Videogame> listByConsole(String consoleName) {
		return repository.searchByConsole(consoleName);
	}
	
	public List<Videogame> order(String recommendedAge, String order) {
		return repository.orderBy(recommendedAge, order);
	}

	


}
