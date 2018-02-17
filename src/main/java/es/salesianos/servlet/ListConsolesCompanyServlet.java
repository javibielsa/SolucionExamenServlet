package es.salesianos.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.service.CompanyService;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.Service;

public class ListConsolesCompanyServlet extends HttpServlet{
	
private Service<Console> service = new ConsoleService();
private Service<Company> companyService = new CompanyService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> listAllCompanies = companyService.listAll();
		req.setAttribute("listAllCompanies", listAllCompanies);
		List<Console> listAllConsoles = new ArrayList<Console>();
		if(req.getParameter("selectCompany") == null) {
			listAllConsoles = service.listByCompany(listAllCompanies.get(0).getName());
		}else {
			listAllConsoles = service.listByCompany(req.getParameter("selectCompany"));
		}
		req.setAttribute("listAllConsoles", listAllConsoles);
		redirect(req,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListConsolesCompanies.jsp");
		dispatcher.forward(req,resp);
	}

}
