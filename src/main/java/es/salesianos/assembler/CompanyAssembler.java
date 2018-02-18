package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public class CompanyAssembler implements Assembler<Company>{
	
	public Company assembleObjectFrom(HttpServletRequest req) {
		Company company = new Company();
		company.setName(req.getParameter("name"));
		company.setCreationDate(req.getParameter("creationDate"));
		return company;
	}

}
