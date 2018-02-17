package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.Assembler;
import es.salesianos.assembler.VideogameAssembler;
import es.salesianos.model.Videogame;
import es.salesianos.repository.Repository;
import es.salesianos.repository.VideogameRepository;

public class VideogameService implements Service<Videogame>{
	
	private Repository<Videogame> repository = new VideogameRepository();
	private Assembler<Videogame> assembler = new VideogameAssembler();

	public Videogame assembleObjectFromRequest(HttpServletRequest req) {
		return assembler.assembleObjectFrom(req);
	}

	public void insertOrUpdate(Videogame VideogameInFormulary) {
		Videogame VideogameInDatabase = repository.search(VideogameInFormulary);
		if(null == VideogameInDatabase){
			repository.insert(VideogameInFormulary);
		}else{
			repository.update(VideogameInFormulary);
		}
	}
	
	public List<Videogame> listAll() {
		return repository.searchAll();
	}
	
	@Override
	public List<Videogame> listByRecommendedAge(String recommendedAge) {
		return repository.searchByRecommendedAge(recommendedAge);
	}
	
	public List<Videogame> listByConsole(String consoleName) {
		return repository.searchByConsole(consoleName);
	}
	
	@Override
	public List<Videogame> orderByTitle() {
		return repository.orderTitles();
	}

	@Override
	public List<Videogame> listByCompany(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
