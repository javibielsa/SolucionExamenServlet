package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Company;
import es.salesianos.repository.CompanyRepository;

@Service
@Profile("database")
public class CompanyService implements es.salesianos.service.Service<Company>{
	
	private static Logger log = LogManager.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyRepository repository;
	
	public void insert(Company company) {
		log.debug("Insertando la empresa " + company.getName());
		repository.insert(company);
	}
	
	public void delete(Company company) {
		log.debug("Borrando la empresa " + company.getName());
		repository.delete(company);;
	}

	public List<Company> listAll(){
		log.debug("Listando todas las empresas...");
		return repository.searchAll();
	}

}
