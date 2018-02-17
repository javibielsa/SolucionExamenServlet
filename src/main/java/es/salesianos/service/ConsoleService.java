package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.Assembler;
import es.salesianos.assembler.CompanyAssembler;
import es.salesianos.assembler.ConsoleAssembler;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.repository.ConsoleRepository;

public class ConsoleService implements Service<Console>{
	
	private ConsoleRepository repository = new ConsoleRepository();
	private Assembler<Console> assembler = new ConsoleAssembler();
	
	public Console assembleObjectFromRequest(HttpServletRequest req) {
		return assembler.assembleObjectFrom(req);
	}
	
	public void insertOrUpdate(Console consolaFormulario) {
		Console consolaInDatabase = repository.search(consolaFormulario);
		if(null == consolaInDatabase){
			repository.insert(consolaFormulario);
		}else{
			repository.update(consolaFormulario);
		}
	}
	
	public List<Console> listAll(){
		return repository.searchAll();
	}
	
	public List<Console> listByCompany(String empresaFormulario){
		
		return repository.searchByCompany(empresaFormulario);
	}

	@Override
	public List<Console> listByConsole(String consoleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> listByRecommendedAge(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> orderByTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
