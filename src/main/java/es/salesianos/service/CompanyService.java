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
	private Assembler<Company> as = new CompanyAssembler();
	
	public Company assembleObjectFromRequest(HttpServletRequest req) {
		return as.assembleObjectFrom(req);
	}
	
	public void insertOrUpdate(Company CompanyInFormulario) {
		Company CompanyInDatabase = repository.search(CompanyInFormulario);
		if(null == CompanyInDatabase){
			repository.insert(CompanyInFormulario);
		}else{
			repository.update(CompanyInFormulario);
		}
	}

	public List<Company> listAll(){
		return repository.searchAll();
	}

	@Override
	public List<Company> listByCompany(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> listByConsole(String consoleName) {
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
