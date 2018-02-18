package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.Service;

public class RegisterConsoleServlet extends HttpServlet{
	
	private Service<Console> service = new ConsoleService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Console consola = service.assembleObjectFromRequest(req);
		service.insert(consola);
		redirect(req,resp);
		
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListConsoles.jsp");
		dispatcher.forward(req,resp);
	}


}
