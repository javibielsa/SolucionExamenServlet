package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.Assembler;
import es.salesianos.assembler.CompanyAssembler;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.repository.CompanyRepository;

public class CompanyService implements Service<Company>{
	
	private CompanyRepository repository = new CompanyRepository();
	private Assembler<Company> assembler = new CompanyAssembler();
	
	public Company assembleObjectFromRequest(HttpServletRequest req) {
		return assembler.assembleObjectFrom(req);
	}
	
	public void insert(Company formularyCompany) {
		repository.insert(formularyCompany);
	}
	
	public void delete(Company formularyCompany) {
		repository.delete(formularyCompany);;
	}

	public List<Company> listAll(){
		return repository.searchAll();
	}

}
