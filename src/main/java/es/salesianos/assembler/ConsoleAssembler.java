package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.repository.CompanyRepository;

public class ConsoleAssembler implements Assembler<Console>{
	
	CompanyRepository repository = new CompanyRepository();
	
	public Console assembleObjectFrom(HttpServletRequest req) {
		Console console = new Console();
		console.setName(req.getParameter("nombre"));
		Company company = new Company();
		company.setName(req.getParameter("selectCompany"));
		console.setCompany(repository.search(company));
		return console;
	}

}
