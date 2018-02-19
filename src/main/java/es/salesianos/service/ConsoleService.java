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
	
	public void insert(Console console) {
		repository.insert(console);
	}
	
	public void delete(Console console) {
		repository.delete(console);
	}
	
	public List<Console> listAll(){
		return repository.searchAll();
	}
	
	public List<Console> listByCompany(String object){
		return repository.searchByCompany(object);
	}


}
