package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Company;
import es.salesianos.service.CompanyService;
import es.salesianos.service.Service;

public class RegisterCompanyServlet extends HttpServlet{
	
public Service<Company> service = new CompanyService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company company = service.assembleObjectFromRequest(req);
		service.insert(company);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListCompanies.jsp");
		dispatcher.forward(req,resp);
	}

}
